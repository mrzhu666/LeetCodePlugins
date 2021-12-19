//Given a circular integer array nums of length n, return the maximum possible 
//sum of a non-empty subarray of nums. 
//
// A circular array means the end of the array connects to the beginning of the 
//array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the 
//previous element of nums[i] is nums[(i - 1 + n) % n]. 
//
// A subarray may only include each element of the fixed buffer nums at most 
//once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not 
//exist i <= k1, k2 <= j with k1 % n == k2 % n. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,-2,3,-2]
//Output: 3
//Explanation: Subarray [3] has maximum sum 3.
// 
//
// Example 2: 
//
// 
//Input: nums = [5,-3,5]
//Output: 10
//Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
// 
//
// Example 3: 
//
// 
//Input: nums = [-3,-2,-3]
//Output: -2
//Explanation: Subarray [-2] has maximum sum -2.
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// 
// Related Topics 队列 数组 分治 动态规划 单调队列 👍 261 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class MaximumSumCircularSubarray{
  public static void main(String[] args) {
    Solution solution = new MaximumSumCircularSubarray().new Solution();
    System.out.print(solution);
  }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
      int answer=nums[0];
      int n=nums.length;
      int[] dp=new int[n];
      dp[0]=nums[0];
      for(int i=1;i<n;i++){
        if(dp[i-1]>0) dp[i]=dp[i-1]+nums[i];
        else dp[i]=nums[i];
        answer=Math.max(answer,dp[i]);
      }
      int[] bp=new int[n];
      bp[n-1]=nums[n-1];
      int sum=nums[n-1];
      for(int i=n-2;i>-1;i--){
        sum+=nums[i];
        bp[i]=Math.max(bp[i+1],sum);
      }
      sum=0;
      for(int i=0;i<n-1;i++){
        sum+=nums[i];
        answer=Math.max(answer,sum+bp[i+1]);
      }
//      System.out.println(Arrays.deepToString(dp));
      return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}