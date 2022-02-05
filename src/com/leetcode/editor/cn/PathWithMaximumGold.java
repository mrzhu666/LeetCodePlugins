package com.leetcode.editor.cn;

//In a gold mine grid of size m x n, each cell in this mine has an integer 
//representing the amount of gold in that cell, 0 if it is empty. 
//
// Return the maximum amount of gold you can collect under the conditions: 
//
// 
// Every time you are located in a cell you will collect all the gold in that 
//cell. 
// From your position, you can walk one step to the left, right, up, or down. 
// You can't visit the same cell more than once. 
// Never visit a cell with 0 gold. 
// You can start and stop collecting gold from any position in the grid that 
//has some gold. 
// 
//
// 
// Example 1: 
//
// 
//Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
//Output: 24
//Explanation:
//[[0,6,0],
// [5,8,7],
// [0,9,0]]
//Path to get the maximum gold, 9 -> 8 -> 7.
// 
//
// Example 2: 
//
// 
//Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
//Output: 28
//Explanation:
//[[1,0,7],
// [2,0,6],
// [3,4,5],
// [0,3,0],
// [9,0,20]]
//Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 15 
// 0 <= grid[i][j] <= 100 
// There are at most 25 cells containing gold. 
// 
// Related Topics 数组 回溯 矩阵 👍 160 👎 0


import java.util.*;
import java.lang.*;

public class PathWithMaximumGold {
    public static void main (String[] args){
        Solution solution = new PathWithMaximumGold().new Solution();
        System.out.println(solution);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int ans=0;
        int n,m;
        int[][] actions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int getMaximumGold(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0)
                    dfs(i,j,0,vis,grid);
            }
        }
        return ans;
    }
    public void dfs(int i,int j,int total,boolean[][] vis,int[][] grid){
        if(i<0 || n-1<i || j<0 || m-1<j || vis[i][j] || grid[i][j]==0)
            return;
        vis[i][j]=true;
        ans=Math.max(ans,total+grid[i][j]);
        
        for(int[] action:actions)
            dfs(i+action[0],j+action[1],total+grid[i][j],vis,grid);
        
        vis[i][j]=false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}

