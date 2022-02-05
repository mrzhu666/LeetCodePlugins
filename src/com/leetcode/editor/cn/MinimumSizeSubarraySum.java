package com.leetcode.editor.cn;

//Given an array of positive integers nums and a positive integer target, 
//return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, 
//numsr] of which the sum is greater than or equal to target. If there is no such 
//subarray, return 0 instead. 
//
// 
// Example 1: 
//
// 
//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem 
//constraint.
// 
//
// Example 2: 
//
// 
//Input: target = 4, nums = [1,4,4]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//Follow up: If you have figured out the O(n) solution, try coding another 
//solution of which the time complexity is O(n log(n)). Related Topics 数组 二分查找 前缀和 滑动窗口
// 👍 923 👎 0


import java.util.*;
import java.lang.*;

public class MinimumSizeSubarraySum {
    public static void main (String[] args){
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        System.out.println(solution.minSubArrayLen(4,new int[]{1,4,4}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans=Integer.MAX_VALUE;
        int n=nums.length;
        int v=nums[0];
        int left=0,right=0;
        while(left<n && right<n){
            if(v>=target){
                ans=Math.min(ans,right-left+1);
                if(left<right){
                    v-=nums[left];
                    left++;
                }else{
                    v-=nums[left];
                    left++;right++;
                    if(right<n)
                        v+=nums[left];
                }
            }else if(right<n-1){
                right++;
                v+=nums[right];
            }else
                break;
        }
        
        return ans==Integer.MAX_VALUE?0:ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}

