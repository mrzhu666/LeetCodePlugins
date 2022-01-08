//An n-bit gray code sequence is a sequence of 2ⁿ integers where: 
//
// 
// Every integer is in the inclusive range [0, 2ⁿ - 1], 
// The first integer is 0, 
// An integer appears no more than once in the sequence, 
// The binary representation of every pair of adjacent integers differs by 
//exactly one bit, and 
// The binary representation of the first and last integers differs by exactly 
//one bit. 
// 
//
// Given an integer n, return any valid n-bit gray code sequence. 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: [0,1,3,2]
//Explanation:
//The binary representation of [0,1,3,2] is [00,01,11,10].
//- 00 and 01 differ by one bit
//- 01 and 11 differ by one bit
//- 11 and 10 differ by one bit
//- 10 and 00 differ by one bit
//[0,2,3,1] is also a valid gray code sequence, whose binary representation is [
//00,10,11,01].
//- 00 and 10 differ by one bit
//- 10 and 11 differ by one bit
//- 11 and 01 differ by one bit
//- 01 and 00 differ by one bit
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [0,1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 16 
// 
// Related Topics 位运算 数学 回溯 👍 394 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class GrayCode{
  public static void main(String[] args) {
    Solution solution = new GrayCode().new Solution();
    System.out.print(solution.grayCode(4));
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> grayCode(int n) {
      List<Integer> ans=new ArrayList<>();
      ans.add(0);ans.add(1);
      int num=2;
      for(int i=2;i<=n;i++){
        for(int j=num-1;j>=0;j--)
          ans.add(ans.get(j)+num);
        num*=2;
      }

      return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}