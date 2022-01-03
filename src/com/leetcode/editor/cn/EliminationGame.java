//You have a list arr of all integers in the range [1, n] sorted in a strictly 
//increasing order. Apply the following algorithm on arr: 
//
// 
// Starting from left to right, remove the first number and every other number 
//afterward until you reach the end of the list. 
// Repeat the previous step again, but this time from right to left, remove the 
//rightmost number and every other number from the remaining numbers. 
// Keep repeating the steps again, alternating left to right and right to left, 
//until a single number remains. 
// 
//
// Given the integer n, return the last number that remains in arr. 
//
// 
// Example 1: 
//
// 
//Input: n = 9
//Output: 6
//Explanation:
//arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
//arr = [2, 4, 6, 8]
//arr = [2, 6]
//arr = [6]
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁹ 
// 
// Related Topics 数学 👍 166 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class EliminationGame{
  public static void main(String[] args) {
    Solution solution = new EliminationGame().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastRemaining(int n) {
      if(n==1) return 1;
      int ans=1;
      int d2=0;
      int dpow=1;
      while(n!=1){
        if(d2%2==0)
          ans+=dpow;
        else if(n%2==1)
            ans+=dpow;
        n/=2;
        d2++;
        dpow*=2;
      }
      return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}