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
      int p1=0,p2=0,i=1;
      int val;
      /*考虑初始化，使两个指针分别指向1和2的头部，麻烦*/
      while(i<n && p1==p2){
        if(nums[i]==0){
          val=nums[p1];
          nums[p1]=nums[i];
          nums[i]=val;
          p1++;p2++;
        }
        else if(nums[i]==1){
          if(nums[p2]==2){
            nums[p2]=1;
            nums[i]=2;
            p2++;
          }
          else if(nums[p1]==0){
            p1++;p2++;
          }

        }
        else{
          if(nums[p1]==1)
            p2=i;
          else if(nums[p1]==0){
            p1++;p2++;
          }
        }
        i++;
      }
//      System.out.println(Arrays.toString(nums)+' '+i+' '+p1+' '+p2);
      for(;i<n && p2<n;i++){
        if(nums[i]==0){
          nums[p1]=0;
          nums[p2]=1;
          nums[i]=2;
          p1++;p2++;
        }
        else if(nums[i]==1){
          nums[p2]=1;
          nums[i]=2;
          p2++;
        }
//        System.out.println(Arrays.toString(nums)+' '+i+' '+p1+' '+p2);
      }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}