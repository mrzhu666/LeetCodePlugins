package com.leetcode.editor.cn;

//You are given a sorted array consisting of only integers where every element 
//appears exactly twice, except for one element which appears exactly once. 
//
// Return the single element that appears only once. 
//
// Your solution must run in O(log n) time and O(1) space. 
//
// 
// Example 1: 
// Input: nums = [1,1,2,3,3,4,4,8,8]
//Output: 2
// Example 2: 
// Input: nums = [3,3,7,7,10,11,11]
//Output: 10
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 二分查找 👍 445 👎 0


import java.util.*;
import java.lang.*;

public class SingleElementInASortedArray {
    public static void main (String[] args){
        Solution solution = new SingleElementInASortedArray().new Solution();
        System.out.println(solution);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left=0,right=(nums.length-1)/2;
        if(left==right || nums[0]!=nums[1]) return nums[0];

        while(right-left>1){
            int mid=left+(right-left)/2;
            if(nums[2*mid]==nums[2*mid+1])
                left=mid;
            else
                right=mid;
        }
        return nums[2*right];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}

