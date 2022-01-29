package com.leetcode.editor.cn;

import java.lang.*;
import java.util.LinkedList;
import java.util.Queue;

public class MapofHighestPeak {
    public static void main (String[] args){
        Solution solution = new MapofHighestPeak().new Solution();
        System.out.println(solution);
    }

    class Solution {
        int n;
        int m;
        public int[][] highestPeak(int[][] isWater) {
            n=isWater.length;
            m=isWater[0].length;
            int[][] actions=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
            int[][] height=new int[n][m];
            boolean[][] vis=new boolean[n][m];
            int[] tmp;
            Queue<int[]> q=new LinkedList<>();
            for(int i=0;i<n;i++)
                for(int j=0;j<m;j++)
                    if(isWater[i][j]==1)
                        q.add(new int[]{i,j,0});
            while(!q.isEmpty()){
                tmp=q.poll();
                for(int[] action:actions)
                    if(bfs(tmp[0]+action[0],tmp[1]+action[1],tmp[2]+1,height,isWater,vis))
                        q.add(new int[]{tmp[0]+action[0],tmp[1]+action[1],tmp[2]+1});
            }
            return height;
        }
        public boolean bfs(int i, int j, int v, int[][] height, int[][] isWater, boolean[][] vis){
            // 出界
            if(i<0 || i>n-1 || j<0 || j>m-1) return false;
            // 该位置为0，或搜索过
            if(isWater[i][j]==1 || vis[i][j]) return false;
            vis[i][j]=true;
            if(height[i][j]==0 || Math.abs(height[i][j]-v+1)>1)
                height[i][j]=v;
            return true;
        }
    }
    // dfs 超时
    class Solution1 {
        int n;
        int m;
        public int[][] highestPeak(int[][] isWater) {
            n=isWater.length;
            m=isWater[0].length;

            int[][] height=new int[n][m];
            boolean[][] vis=new boolean[n][m];
            for(int i=0;i<n;i++)
                for(int j=0;j<m;j++)
                    if(isWater[i][j]==1){
                        dfs(i+1,j,1,height,isWater,vis);
                        dfs(i-1,j,1,height,isWater,vis);
                        dfs(i,j-1,1,height,isWater,vis);
                        dfs(i,j+1,1,height,isWater,vis);
                    }
            return height;
        }
        public void dfs(int i,int j,int v,int[][] height,int[][] isWater,boolean[][] vis){
            if(i<0 || i>n-1 || j<0 || j>m-1) return;
            if(isWater[i][j]==1 || vis[i][j]) return;
            vis[i][j]=true;

            if(height[i][j]==0 || Math.abs(height[i][j]-v+1)>1){
                height[i][j]=v;
                dfs(i+1,j,v+1,height,isWater,vis);
                dfs(i-1,j,v+1,height,isWater,vis);
                dfs(i,j-1,v+1,height,isWater,vis);
                dfs(i,j+1,v+1,height,isWater,vis);
            }

            vis[i][j]=false;
        }
    }

}
