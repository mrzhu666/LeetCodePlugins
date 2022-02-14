package com.leetcode.editor.cn;

//Given an array of integers nums and an integer k, return the number of 
//contiguous subarrays where the product of all the elements in the subarray is strictly 
//less than k. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,5,2,6], k = 100
//Output: 8
//Explanation: The 8 subarrays that have product less than 100 are:
//[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
//Note that [10, 5, 2] is not included as the product of 100 is not strictly 
//less than k.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3], k = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 10⁶ 
// 
// Related Topics 数组 滑动窗口 👍 338 👎 0


import java.util.*;
import java.lang.*;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        Solution solution = new SubarrayProductLessThanK().new Solution();
        System.out.println(solution);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int n = nums.length;
            int ans = 0;
            
            int v = nums[0], left = 0, right = 0;
            while (left < n) {
                if (v < k){
                    ans+=right-left+1;
                    if(right==n-1){
                        break;
                    }else{
                        right++;
                        v*=nums[right];
                    }
                }else{
                    v/=nums[left++];
                }
            }
            
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}

