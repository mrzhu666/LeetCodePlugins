//Given a non-empty array nums containing only positive integers, find if the 
//array can be partitioned into two subsets such that the sum of elements in both 
//subsets is equal. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 1026 👎 0


package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class PartitionEqualSubsetSum{
  public static void main(String[] args) {
    Solution solution = new PartitionEqualSubsetSum().new Solution();
    System.out.print(solution.canPartition(new int[]{1,5,11,5}));
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public boolean canPartition(int[] nums) {
    int maxSum = Arrays.stream(nums).sum();
    if (maxSum % 2 == 1) return false;
    int target = maxSum / 2;
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;
    for (int i : nums) {
      for (int j = target - i; j >= 0; j--) {
        if (dp[j]) dp[j + i] = true;
      }
      if (dp[target]) return true;
    }
    return false;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

}