//Given an integer array nums, find a contiguous non-empty subarray within the 
//array that has the largest product, and return the product. 
//
// The test cases are generated so that the answer will fit in a 32-bit integer.
// 
//
// A subarray is a contiguous subsequence of the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
// 
// Related Topics 数组 动态规划 👍 1405 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class MaximumProductSubarray{
  public static void main(String[] args) {
    Solution solution = new MaximumProductSubarray().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
      int n=nums.length;
      int maxDp,preMax;
      int minDp;
      maxDp=nums[0];
      minDp=nums[0];
      int answer=nums[0];
      for(int i=1;i<n;i++){
        if(nums[i]>0) {
          maxDp=Math.max(nums[i],maxDp*nums[i]);
          minDp=Math.min(nums[i],minDp*nums[i]);
        }
        else{
          preMax=maxDp;
          maxDp=Math.max(nums[i],minDp*nums[i]);
          minDp=Math.min(nums[i],preMax*nums[i]);
        }
        answer=Math.max(answer,maxDp);
      }
      return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class Solution1 {
    public int maxProduct(int[] nums) {
      int n=nums.length;
      int[] maxDp=new int[n];
      int[] minDp=new int[n];
      maxDp[0]=nums[0];
      minDp[0]=nums[0];
      int answer=nums[0];
      for(int i=1;i<n;i++){
        if(nums[i]>0) {
          maxDp[i]=Math.max(nums[i],maxDp[i-1]*nums[i]);
          minDp[i]=Math.min(nums[i],minDp[i-1]*nums[i]);
        }
        else{
          maxDp[i]=Math.max(nums[i],minDp[i-1]*nums[i]);
          minDp[i]=Math.min(nums[i],maxDp[i-1]*nums[i]);
        }
        answer=Math.max(answer,maxDp[i]);
      }
      return answer;
    }
}

}