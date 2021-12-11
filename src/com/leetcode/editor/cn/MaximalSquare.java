//Given an m x n binary matrix filled with 0's and 1's, find the largest square 
//containing only 1's and return its area. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1",
//"1"],["1","0","0","1","0"]]
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: matrix = [["0","1"],["1","0"]]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: matrix = [["0"]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] is '0' or '1'. 
// 
// Related Topics 数组 动态规划 矩阵 👍 943 👎 0

package com.leetcode.editor.cn;

import java.lang.*;
import java.util.Arrays;

public class MaximalSquare {
  public static void main(String[] args) {
    Solution solution = new MaximalSquare().new Solution();
    System.out.print(solution.maximalSquare(new char[][]{{'0', '0'}, {'1', '1'}}
    ));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  // 优化1：原数组更改
  // 优化2：状态转移方案更改
  class Solution {
    public char minOfThress(char a, char b, char c) {
      return (char) Math.min(Math.min(a, b), c);
    }
    public int maximalSquare(char[][] matrix) {
      int answer = 0;
      int m = matrix.length, n = matrix[0].length;
      for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++) {
          matrix[i][j] -= '0';
          if (i != 0 && j != 0 && matrix[i][j] == 1) {
            matrix[i][j] = (char) (minOfThress(matrix[i - 1][j], matrix[i][j - 1], matrix[i - 1][j - 1]) + 1);
          }
          answer = Math.max(matrix[i][j], answer);
        }
      return answer * answer;
    }
  }

  //leetcode submit region end(Prohibit modification and deletion)
  class Solution1 {
    int[][] preMatrix;
    int[][] dp;

    /**
     * 返回最大以(i,j)为右下角的最大正方形长度
     *
     * @param i 行
     * @param j 列
     * @return 返回边长
     */
    public int square(int i, int j) {
      int n = dp[i - 1][j - 1] + 1;
      for (int k = n; k > 1; k--) {
        int sum = preMatrix[i][j] - preMatrix[i - k][j] - preMatrix[i][j - k] + preMatrix[i - k][j - k];
        if (sum == k * k)
          return k;
      }
      return 1;
    }

    public int maximalSquare(char[][] matrix) {
      int answer = 0;
      int m = matrix.length, n = matrix[0].length;
      preMatrix = new int[m + 1][n + 1];
      dp = new int[m + 1][n + 1];
      for (int i = 1; i <= m; i++)
        for (int j = 1; j <= n; j++) {
          preMatrix[i][j] = preMatrix[i][j - 1] + preMatrix[i - 1][j] - preMatrix[i - 1][j - 1];
          if (matrix[i - 1][j - 1] == '1') {
            preMatrix[i][j] += 1;
            dp[i][j] = 1;
            answer = 1;
          }
        }
      for (int i = 1; i <= m; i++)
        for (int j = 1; j <= n; j++) {
          if (dp[i][j] == 1) {
            dp[i][j] = square(i, j);
            answer = Math.max(dp[i][j], answer);
          }
        }
      return answer * answer;
    }
  }

}