//Given an n x n array of integers matrix, return the minimum sum of any 
//falling path through matrix. 
//
// A falling path starts at any element in the first row and chooses the 
//element in the next row that is either directly below or diagonally left/right. 
//Specifically, the next element from position (row, col) will be (row + 1, col - 1), (
//row + 1, col), or (row + 1, col + 1). 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
//Output: 13
//Explanation: There are two falling paths with a minimum sum as shown.
// 
//
// Example 2: 
//
// 
//Input: matrix = [[-19,57],[-40,-5]]
//Output: -59
//Explanation: The falling path with a minimum sum is shown.
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 👍 138 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class MinimumFallingPathSum{
  public static void main(String[] args) {
    Solution solution = new MinimumFallingPathSum().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int minFallingPathSum(int[][] matrix) {
    int n=matrix.length;
    if(n==1) return matrix[0][0];
    int m=matrix[0].length;
    int[][] dp=new int[2][m];
    dp[0]=Arrays.copyOf(matrix[0],m);
    for(int i=1;i<n;i++){
      dp[i%2][0]=Math.min(dp[(i-1)%2][0],dp[(i-1)%2][1])+matrix[i][0];
      dp[i%2][m-1]=Math.min(dp[(i-1)%2][m-2],dp[(i-1)%2][m-1])+matrix[i][m-1];
      for(int j=1;j<m-1;j++)
        dp[i%2][j]=Math.min(dp[(i-1)%2][j],Math.min(dp[(i-1)%2][j-1],dp[(i-1)%2][j+1]))+matrix[i][j];
    }
    return Arrays.stream(dp[(n-1)%2]).min().getAsInt();
  }
}
//leetcode submit region end(Prohibit modification and deletion)

}