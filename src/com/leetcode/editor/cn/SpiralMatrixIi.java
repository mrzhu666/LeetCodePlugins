//Given a positive integer n, generate an n x n matrix filled with elements 
//from 1 to n² in spiral order. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: [[1,2,3],[8,9,4],[7,6,5]]
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 👍 568 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class SpiralMatrixIi {
  public static void main(String[] args) {
    Solution solution = new SpiralMatrixIi().new Solution();
    System.out.print(Arrays.toString(solution.generateMatrix(4)));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[][] generateMatrix(int n) {
      int[][] ans = new int[n][n];
      int k = 1;
      int i = 0;
      int j = 0;
      for (int r = 0; r < (float) n / 2; r++) {
        for (; j < n - r; j++)
          ans[i][j] = k++;
        j--;
        for (i++; i < n - r; i++)
          ans[i][j] = k++;
        i--;
        for (j--; j > -1 + r; j--)
          ans[i][j] = k++;
        j++;
        for (i--; i > r; i--)
          ans[i][j] = k++;
        i++;j++;
      }
      return ans;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}