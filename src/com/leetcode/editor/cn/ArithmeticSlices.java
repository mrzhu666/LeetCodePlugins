//An integer array is called arithmetic if it consists of at least three 
//elements and if the difference between any two consecutive elements is the same. 
//
// 
// For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic 
//sequences. 
// 
//
// Given an integer array nums, return the number of arithmetic subarrays of 
//nums. 
//
// A subarray is a contiguous subsequence of the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4]
//Output: 3
//Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,
//2,3,4] itself.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -1000 <= nums[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 392 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class ArithmeticSlices{
  public static void main(String[] args) {
    Solution solution = new ArithmeticSlices().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
  public int numberOfArithmeticSlices(int[] nums) {
    if(nums.length<3) return 0;
    int answer=0;
    int predp=2;
    for(int i=2;i<nums.length;i++){
      if(nums[i-1]-nums[i-2]==nums[i]-nums[i-1]){
        predp=predp+1;
        answer+=predp-2;
      }
      else{
        predp=2;
      }
    }
    return answer;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

}