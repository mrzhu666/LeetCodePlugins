//You are given an integer array nums where the largest integer is unique. 
//
// Determine whether the largest element in the array is at least twice as much 
//as every other number in the array. If it is, return the index of the largest 
//element, or return -1 otherwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,6,1,0]
//Output: 1
//Explanation: 6 is the largest integer.
//For every other number in the array x, 6 is at least twice as big as x.
//The index of value 6 is 1, so we return 1.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4]
//Output: -1
//Explanation: 4 is less than twice the value of 3, so we return -1. 
//
// Example 3: 
//
// 
//Input: nums = [1]
//Output: 0
//Explanation: 1 is trivially at least twice the value as any other number 
//because there are no other numbers.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 50 
// 0 <= nums[i] <= 100 
// The largest element in nums is unique. 
// 
// Related Topics 数组 排序 👍 148 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class LargestNumberAtLeastTwiceOfOthers{
  public static void main(String[] args) {
    Solution solution = new LargestNumberAtLeastTwiceOfOthers().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int dominantIndex(int[] nums) {
      int n=nums.length;
      if(n==1) return 0;
      int first,second;
      if(nums[0]>nums[1]){
        first=0;
        second=1;
      }else{
        first=1;
        second=0;
      }

      for(int i=2;i<n;i++){
        if(nums[i]>nums[first]){
          second=first;
          first=i;
        }
        else if(nums[i]>nums[second])
          second=i;
      }
      return nums[first]>=2*nums[second]?first:-1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}