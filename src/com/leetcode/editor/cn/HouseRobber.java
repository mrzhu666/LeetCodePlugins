//You are a professional robber planning to rob houses along a street. Each 
//house has a certain amount of money stashed, the only constraint stopping you from 
//robbing each of them is that adjacent houses have security systems connected and 
//it will automatically contact the police if two adjacent houses were broken 
//into on the same night. 
//
// Given an integer array nums representing the amount of money of each house, 
//return the maximum amount of money you can rob tonight without alerting the 
//police. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 
//(money = 1).
//Total amount you can rob = 2 + 9 + 1 = 12.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 数组 动态规划 👍 1767 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class HouseRobber{
  public static void main(String[] args) {
    Solution solution = new HouseRobber().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
      int n=nums.length;
      int dp=0,bp=0;
      int predp;
      for(int i=0;i<n;i++){
        predp=dp;
        dp=bp+nums[i];
        bp=Math.max(predp,bp);
      }
      return Math.max(dp,bp);
//      int[] dp=new int[n+1];
//      int[] bp=new int[n+1];
//      for(int i=1;i<=n;i++){
//        dp[i]=bp[i-1]+nums[i-1];
//        bp[i]=Math.max(dp[i-1],bp[i-1]);
//      }
//      return Math.max(dp[n],bp[n]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}