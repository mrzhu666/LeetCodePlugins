//You are given an integer array nums. You are initially positioned at the 
//array's first index, and each element in the array represents your maximum jump 
//length at that position. 
//
// Return true if you can reach the last index, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum 
//jump length is 0, which makes it impossible to reach the last index.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 动态规划 👍 1542 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class JumpGame{
  public static void main(String[] args) {
    Solution solution = new JumpGame().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
      int a=1;
      int n=nums.length;
      for(int i=n-2;i>-1;i--){
        if(nums[i]>=a){
          a=1;
        }
        else{
          a++;
        }
      }
      if(a==1) return true;
      else return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class Solution2 {
    boolean[] vis;
    int[] nums;
    int n;
    public boolean dfs(int index){
      if(index>=n-1) return true;
      if(vis[index]) return false;

      for(int i=nums[index];i>=1;i--){
        if(dfs(index+i)) return true;
      }
      vis[index]=true;
      return false;
    }
    public boolean canJump(int[] nums) {
      n=nums.length;
      this.nums=nums;
      vis=new boolean[n];
      return dfs(0);
    }
}


class Solution1 {
    public boolean canJump(int[] nums) {
      int n=nums.length;
      boolean[] dp=new boolean[n];
      dp[0]=true;
      for(int i=0;i<n;i++){
        if(dp[i]){
          for(int j=1;j+i<n && j<=nums[i];j++){
            dp[i+j]=true;
          }
        }
      }
      return dp[n-1];
    }
}


}