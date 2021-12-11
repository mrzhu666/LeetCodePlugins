//Given an integer array nums and an integer k, find three non-overlapping 
//subarrays of length k with maximum sum and return them. 
//
// Return the result as a list of indices representing the starting position of 
//each interval (0-indexed). If there are multiple answers, return the 
//lexicographically smallest one. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,1,2,6,7,5,1], k = 2
//Output: [0,3,5]
//Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting 
//indices [0, 3, 5].
//We could have also taken [2, 1], but an answer of [1, 3, 5] would be 
//lexicographically larger.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,1,2,1,2,1,2,1], k = 2
//Output: [0,2,4]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] < 2¹⁶ 
// 1 <= k <= floor(nums.length / 3) 
// 
// Related Topics 数组 动态规划 👍 176 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class MaximumSumOf3NonOverlappingSubarrays{
  public static void main(String[] args) {
    Solution solution = new MaximumSumOf3NonOverlappingSubarrays().new Solution();
    System.out.print(solution.maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1},2));
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    int n=nums.length;
    int maxSum1Index1=0,maxSum2Index1=0,maxSum2Index2=k;
    int[] answer=new int[3];
    int sum1=0,sum2=0,sum3=0;
    int maxSum1=0,maxSum2=0,maxSum3=0;
    for(int i=2*k;i<n;i++){
      sum1+=nums[i-2*k];
      sum2+=nums[i-k];
      sum3+=nums[i];
      if(i>=3*k-1){
        if(sum1>maxSum1){
          maxSum1=sum1;
          maxSum1Index1=i-3*k+1;
        }
        if(sum2+maxSum1>maxSum2){
          maxSum2=sum2+maxSum1;
          maxSum2Index1=maxSum1Index1;
          maxSum2Index2=i-2*k+1;
        }
        if(sum3+maxSum2>maxSum3){
          maxSum3=sum3+maxSum2;
          answer[0]=maxSum2Index1;
          answer[1]=maxSum2Index2;
          answer[2]=i-k+1;
        }
        sum1-=nums[i-3*k+1];
        sum2-=nums[i-2*k+1];
        sum3-=nums[i-k+1];
      }
    }
    return answer;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

}