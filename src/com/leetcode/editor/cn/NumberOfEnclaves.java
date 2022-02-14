package com.leetcode.editor.cn;

//You are given an m x n binary matrix grid, where 0 represents a sea cell and 1
// represents a land cell. 
//
// A move consists of walking from one land cell to another adjacent (4-
//directionally) land cell or walking off the boundary of the grid. 
//
// Return the number of land cells in grid for which we cannot walk off the 
//boundary of the grid in any number of moves. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//Output: 3
//Explanation: There are three 1s that are enclosed by 0s, and one 1 that is 
//not enclosed because its on the boundary.
// 
//
// Example 2: 
//
// 
//Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//Output: 0
//Explanation: All 1s are either on the boundary or can reach the boundary.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] is either 0 or 1. 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 99 👎 0


import java.util.*;
import java.lang.*;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        Solution solution = new NumberOfEnclaves().new Solution();
        System.out.println(solution.numEnclaves(new int[][]{{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n, m;
        int[][] grid;
        
        HashMap<Integer,Integer> parent=new HashMap<>();
        HashMap<Integer,Integer> size=new HashMap<>();
        
        public int find(int x){
            while(x!=parent.get(x)){
                parent.put(x,parent.get(parent.get(x)));
                x=parent.get(x);
            }
            return x;
        }
        
        public void union(int x,int y){
            x=find(x);
            y=find(y);
            if(x==y) return;
            
            parent.put(x,y);
            size.merge(y,size.get(x),Integer::sum);
        }
        
        public int getIndex(int i,int j){
            return i*m+j;
        }
        
        public void merge(int i,int j,int k,int z){
            int x=getIndex(i,j);
            int y=getIndex(k,z);
            union(x,y);
        }
        
        public void search(int i,int j,int k,int z){
            if(k<0 || n-1<k || z<0 || m-1<z){
                merge(i,j,n,m);
                return;
            }
            if(grid[k][z]==1)
                merge(i,j,k,z);
        }
        
        public void init(int i,int j){
            int x=getIndex(i,j);
            parent.put(x,x);
            size.put(x,1);
        }
        
        public int numEnclaves(int[][] grid) {
            int[][] actions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            n = grid.length;
            m = grid[0].length;
            
            this.grid = grid;
            int land=0;
            
            for(int i=0;i<n;i++)
                for(int j=0;j<m;j++)
                    if(grid[i][j]==1){
                        land++;
                        init(i,j);
                    }
            init(n,m);
            
            for(int i=0;i<n;i++)
                for(int j=0;j<m;j++)
                    if(grid[i][j]==1)
                        for(int[] action:actions){
                            search(i,j,i+action[0],j+action[1]);
                        }
                
            
            return land-size.get(find(getIndex(n,m)))+1;
        }
    }
    
//leetcode submit region end(Prohibit modification and deletion)
    
    class Solution1 {
        int n, m;
        int[][] vis;
        int[][] grid;
        int[][] actions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        public boolean dfs(int i, int j) {
            // true代表出界
            if (i < 0 || n - 1 < i || j < 0 || m - 1 < j)
                return true;
            if (grid[i][j] == 0 || vis[i][j] == 1) return false;
            if (vis[i][j] == 2) return true;
            
            vis[i][j] = 1;
            for (int[] action : actions) {
                if (dfs(i + action[0], j + action[1])) {
                    vis[i][j] = 2;
                    dfs(i, j);
                    return true;
                }
            }
            vis[i][j] = 0;
            
            return false;
        }
        
        public int numEnclaves(int[][] grid) {
            
            n = grid.length;
            m = grid[0].length;
            this.grid = grid;
            // 0未探索或者是海洋，1是陆地但不保证完全不出界，2是陆地可以出界
            vis = new int[n][m];
            int ans = 0;
            int land = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (vis[i][j] == 0 && grid[i][j] == 1)
                        dfs(i, j);
            
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1)
                        land++;
                    if (vis[i][j] == 2)
                        ans++;
                }
            
            
            return land-ans;
        }
    }
    
}

