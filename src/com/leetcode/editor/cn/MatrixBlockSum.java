//Given a m x n matrix mat and an integer k, return a matrix answer where each 
//answer[i][j] is the sum of all elements mat[r][c] for: 
//
// 
// i - k <= r <= i + k, 
// j - k <= c <= j + k, and 
// (r, c) is a valid position in the matrix. 
// 
//
// 
// Example 1: 
//
// 
//Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//Output: [[12,21,16],[27,45,33],[24,39,28]]
// 
//
// Example 2: 
//
// 
//Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
//Output: [[45,45,45],[45,45,45],[45,45,45]]
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n, k <= 100 
// 1 <= mat[i][j] <= 100 
// 
// Related Topics 数组 矩阵 前缀和 👍 120 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class MatrixBlockSum{
  public static void main(String[] args) {
    Solution solution = new MatrixBlockSum().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int n;
    int m;
    int[][] preSum;
    int[][] mat;
    public int value(int r,int c){
      /*第r行第c列*/
      if(c<1 || c>m) return 0;
      if(r<1 || r>n) return 0;
      return mat[r-1][c-1];
    }

    public int[][] matrixBlockSum(int[][] mat, int k) {
      n=mat.length;
      m=mat[0].length;
      this.mat=mat;
      int[][] sum=new int[n][m];

      return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class Solution1 {
    int n;
    int m;
    int[][] preSum;
    public int colSum(int c,int r1,int r2){
      /*第c列从第r1行到第r2行求和*/
      if(c<1 || c>m) return 0;
      int sum=0;
      if(r2>n) sum=preSum[n][c];
      else sum=preSum[r2][c];
      if(r1>1) sum-=preSum[r1-1][c];
      return sum;
    }

    public int[][] matrixBlockSum(int[][] mat, int k) {
      n=mat.length;
      m=mat[0].length;
      preSum=new int[n+1][m+1];
      int[][] sum=new int[n][m];
      for(int i=1;i<=n;i++)
        for(int j=1;j<=m;j++){
          preSum[i][j]=preSum[i-1][j]+mat[i-1][j-1];
        }
      for(int i=1;i<=n;i++)
        for(int j=1;j<=k+1;j++)
          sum[i-1][0]+=colSum(j,i-k,i+k);

      for(int i=1;i<=n;i++)
        for(int j=2;j<=m;j++){
          sum[i-1][j-1]=sum[i-1][j-2]+colSum(j+k,i-k,i+k)-colSum(j-k-1,i-k,i+k);
        }

      return sum;
    }
}


}