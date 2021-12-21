//Given an array of integers nums, find the maximum length of a subarray where 
//the product of all its elements is positive. 
//
// A subarray of an array is a consecutive sequence of zero or more values 
//taken out of that array. 
//
// Return the maximum length of a subarray with positive product. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,-2,-3,4]
//Output: 4
//Explanation: The array nums already has a positive product of 24.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,-2,-3,-4]
//Output: 3
//Explanation: The longest subarray with positive product is [1,-2,-3] which 
//has a product of 6.
//Notice that we cannot include 0 in the subarray since that'll make the 
//product 0 which is not positive. 
//
// Example 3: 
//
// 
//Input: nums = [-1,-2,-3,0,1]
//Output: 2
//Explanation: The longest subarray with positive product is [-1,-2] or [-2,-3].
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 贪心 数组 动态规划 👍 98 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class MaximumLengthOfSubarrayWithPositiveProduct{
  public static void main(String[] args) {
    Solution solution = new MaximumLengthOfSubarrayWithPositiveProduct().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getMaxLen(int[] nums) {
      int n=nums.length;
      int poDp=0,prePo;
      int neDp=0;
      int answer=0;
      if(nums[0]>0) {
        poDp=1;
        answer=1;
      }
      else if(nums[0]<0)
        neDp=1;
      for(int i=1;i<n;i++){
        if(nums[i]>0){
          poDp++;
          if(neDp>0) neDp++;
        }
        else if(nums[i]<0){
          prePo=poDp;
          if(neDp>0) poDp=neDp+1;
          else poDp=0;
          neDp=prePo+1;
        }
        else{
          poDp=0;
          neDp=0;
        }
        answer=Math.max(answer,poDp);
//        System.out.format("%d %d %d\n",answer,poDp,neDp);
      }

      return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class Solution1 {
    public int getMaxLen(int[] nums) {
      int n=nums.length;
      int[] poDp=new int[n];
      int[] neDp=new int[n];
      int answer=0;
      if(nums[0]>0) {
        poDp[0]=1;
        answer=1;
      }
      else if(nums[0]<0)
        neDp[0]=1;
      for(int i=1;i<n;i++){
        if(nums[i]>0){
          poDp[i]+=poDp[i-1]+1;
          if(neDp[i-1]>0)
            neDp[i]+=neDp[i-1]+1;
        }
        else if(nums[i]<0){
          if(neDp[i-1]>0)
            poDp[i]+=neDp[i-1]+1;
          neDp[i]+=poDp[i-1]+1;
        }
        answer=Math.max(answer,poDp[i]);
      }
      return answer;
    }
}


}