//Given an array nums with n objects colored red, white, or blue, sort them in-
//place so that objects of the same color are adjacent, with the colors in the 
//order red, white, and blue. 
//
// We will use the integers 0, 1, and 2 to represent the color red, white, and 
//blue, respectively. 
//
// You must solve this problem without using the library's sort function. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,0,1]
//Output: [0,1,2]
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] is either 0, 1, or 2. 
// 
//
// 
// Follow up: Could you come up with a one-pass algorithm using only constant 
//extra space? 
// Related Topics 数组 双指针 排序 👍 1120 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class SortColors{
  public static void main(String[] args) {
    Solution solution = new SortColors().new Solution();
    solution.sortColors(new int[]{0,0});
    System.out.println();
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
      int n=nums.length;
      if(n==1) return;
      int left=-1,right=n;
      for(int i=0;i<n && i<right;i++) {
        if(nums[i]==0) {
          nums[++left]=0;
          if(i!=left)
            nums[i]=1;
        }else if(nums[i]==2) {
          nums[i]=nums[--right];
          nums[right]=2;
          i--;
        }
      }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}