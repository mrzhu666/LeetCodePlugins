//You are given an m x n integer matrix grid, and three integers row, col, and 
//color. Each value in the grid represents the color of the grid square at that 
//location. 
//
// Two squares belong to the same connected component if they have the same 
//color and are next to each other in any of the 4 directions. 
//
// The border of a connected component is all the squares in the connected 
//component that are either 4-directionally adjacent to a square not in the component, 
//or on the boundary of the grid (the first or last row or column). 
//
// You should color the border of the connected component that contains the 
//square grid[row][col] with color. 
//
// Return the final grid. 
//
// 
// Example 1: 
// Input: grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
//Output: [[3,3],[3,2]]
// Example 2: 
// Input: grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
//Output: [[1,3,3],[2,3,3]]
// Example 3: 
// Input: grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
//Output: [[2,2,2],[2,1,2],[2,2,2]]
// 
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// 1 <= grid[i][j], color <= 1000 
// 0 <= row < m 
// 0 <= col < n 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 77 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class ColoringABorder{
  public static void main(String[] args) {
    Solution solution = new ColoringABorder().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int n,m;
    int[][] direction=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    int[][] grid;
    boolean[][] vis;
    int color,target;
    public boolean dfs(int row,int col){
      if(row==-1||row==n||col==-1||col==m){
        return true;
      }
      else if(vis[row][col]){
        // 被访问过，可能是已经被修改的边界，可能是访问过的内部区域
        return false;
      }
      else if(grid[row][col]!=target){
        return true;
      }
      vis[row][col]=true;
      for(int i=0;i<4;i++){
        if(dfs(row+direction[i][0],col+direction[i][1])){
          grid[row][col]=color;
        }
      }
      return false;
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
      this.n=grid.length;
      this.m=grid[0].length;
      this.grid=grid;
      this.color=color;
      this.target=grid[row][col];
      this.vis=new boolean[n][m];
      dfs(row,col);
      return grid;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}