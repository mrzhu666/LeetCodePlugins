//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
//k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2: 
// Input: nums = []
//Output: []
// Example 3: 
// Input: nums = [0]
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4098 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class ThreeSum{
  public static void main(String[] args) {
    Solution solution = new ThreeSum().new Solution();
    System.out.print(solution.threeSum(new int[]{-2,0,0,2,2}));
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> answer=new ArrayList<>();
      int n=nums.length;
      if(n<3) return new ArrayList<>();
      Arrays.sort(nums);
      int i,left,right,value;
      for(i=0;i<n-2;i++){
        if(i>0 && nums[i-1]==nums[i]) continue;
        left=i+1;
        right=n-1;
        if(nums[i]>0) return answer;
        while(left<right){
          value=nums[i]+nums[left]+nums[right];
          if(value==0) {
            answer.add(Arrays.asList(nums[i],nums[left],nums[right]));
            while(left<right && nums[++left]==nums[left-1]);
            while(left<right && nums[--right]==nums[right+1]);
          }
          else if(value>0) while(left<right && nums[--right]==nums[right+1]);
          else while(left<right && nums[++left]==nums[left-1]);;
        }
      }
      return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
      Set<List<Integer>> answer=new HashSet<>();
      int n=nums.length;
      if(n<3) return new ArrayList<>();
      Arrays.sort(nums);
      int one,two,three,value;
      for(two=1;two<n-1;two++){
        one=0;
        three=n-1;
        while(one!=two && two!=three && nums[one]<=0 && nums[three]>=0){
          value=nums[one]+nums[two]+nums[three];
          if(value>0) three-=1;
          else if(value<0) one+=1;
          else {
            answer.add(Arrays.asList(nums[one],nums[two],nums[three]));
            one+=1;
          }
        }
      }
      return new ArrayList<>(answer);
    }
}


}