//A perfect number is a positive integer that is equal to the sum of its 
//positive divisors, excluding the number itself. A divisor of an integer x is an 
//integer that can divide x evenly. 
//
// Given an integer n, return true if n is a perfect number, otherwise return 
//false. 
//
// 
// Example 1: 
//
// 
//Input: num = 28
//Output: true
//Explanation: 28 = 1 + 2 + 4 + 7 + 14
//1, 2, 4, 7, and 14 are all divisors of 28.
// 
//
// Example 2: 
//
// 
//Input: num = 7
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= num <= 10⁸ 
// 
// Related Topics 数学 👍 127 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class PerfectNumber{
  public static void main(String[] args) {
    Solution solution = new PerfectNumber().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPerfectNumber(int num) {
      if(num==1) return false;
      int divisor=1;
      for(int i=2;i<=Math.sqrt(num);i++){
        if(num%i==0){
          divisor+=num/i+i;
        }
      }
      return divisor==num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}