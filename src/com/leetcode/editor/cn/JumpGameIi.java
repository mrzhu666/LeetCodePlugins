//Given an array of non-negative integers nums, you are initially positioned at 
//the first index of the array. 
//
// Each element in the array represents your maximum jump length at that 
//position. 
//
// Your goal is to reach the last index in the minimum number of jumps. 
//
// You can assume that you can always reach the last index. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 
//step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,3,0,1,4]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 👍 1321 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class JumpGameIi{
  public static void main(String[] args) {
    Solution solution = new JumpGameIi().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int jump(int[] nums) {
    int maxPosition=0;
    int steps=0;
    int end=0;
    int n=nums.length;
    for(int i=0;i<n-1 && end<n-1;i++){
      maxPosition=Math.max(maxPosition,i+nums[i]);
      if(i==end){
        end=maxPosition;
        steps++;
      }
    }
    return steps;
  }
}
//leetcode submit region end(Prohibit modification and deletion)


class Solution1 {
    int[] dp;
    int n;
    int[] nums;
    public int dfs(int index){
      if(index>=n-1) return 0;
      if(nums[index]==0) return 10000;
      if(dp[index]<10000) return dp[index];
      for(int i=1;i<=nums[index];i++){
        dp[index]=Math.min(dfs(index+i)+1,dp[index]);
      }
      return dp[index];
    }
    public int jump(int[] nums) {
      n=nums.length;
      dp=new int[n];
      Arrays.fill(dp,10000);
      this.nums=nums;
      return dfs(0);
    }
}


}