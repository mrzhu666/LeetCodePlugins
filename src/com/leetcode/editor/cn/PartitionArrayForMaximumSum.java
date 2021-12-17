//Given an integer array arr, partition the array into (contiguous) subarrays 
//of length at most k. After partitioning, each subarray has their values changed 
//to become the maximum value of that subarray. 
//
// Return the largest sum of the given array after partitioning. Test cases are 
//generated so that the answer fits in a 32-bit integer. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,15,7,9,2,5,10], k = 3
//Output: 84
//Explanation: arr becomes [15,15,15,9,10,10,10]
// 
//
// Example 2: 
//
// 
//Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
//Output: 83
// 
//
// Example 3: 
//
// 
//Input: arr = [1], k = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 500 
// 0 <= arr[i] <= 10⁹ 
// 1 <= k <= arr.length 
// 
// Related Topics 数组 动态规划 👍 127 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class PartitionArrayForMaximumSum{
  public static void main(String[] args) {
    Solution solution = new PartitionArrayForMaximumSum().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int maxSumAfterPartitioning(int[] arr, int k) {
    int n=arr.length;
    int[][] maxNum=new int[][];
    int[]dp=new int[n];
    for(int i=0;i<n;i++)
      dp[i]=arr[i];
    for(int len=2;len<=k;len++)
      for(int i=0;i+len-1<n;i++)
        dp[i][i+len-1]=Math.max(dp[i][i],dp[i+1][i+len-1]/(len-1))*len;
    for(int len=k+1;len<=n;len++)
      for(int i=0;i+len-1<n;i++)
        for(int j=1;j<=k;j++){
          dp[i][i+len-1]=Math.max(dp[i][i+len-1],dp[i][i+j-1]+dp[i+j][i+len-1]);
        }

    return dp[0][n-1];
  }
}
//leetcode submit region end(Prohibit modification and deletion)

class Solution1 {
  public int maxSumAfterPartitioning(int[] arr, int k) {
    int n=arr.length;
    int[][]dp=new int[n][n];
    for(int i=0;i<n;i++)
      dp[i][i]=arr[i];
    for(int len=2;len<=k;len++)
      for(int i=0;i+len-1<n;i++)
        dp[i][i+len-1]=Math.max(dp[i][i],dp[i+1][i+len-1]/(len-1))*len;
    for(int len=k+1;len<=n;len++)
      for(int i=0;i+len-1<n;i++)
        for(int j=1;j<=k;j++){
          dp[i][i+len-1]=Math.max(dp[i][i+len-1],dp[i][i+j-1]+dp[i+j][i+len-1]);
        }

    return dp[0][n-1];
  }
}


}