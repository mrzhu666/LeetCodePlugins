package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class NetworkDelayTime {
    public static void main (String[] args){
        Solution solution = new NetworkDelayTime().new Solution();
        System.out.println(solution);
    }

    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            int m=times.length;
            int[] edgesIndex=new int[m+1];
            int[] head=new int[n+1];
            int u,v;
            for(int i=1;i<=m;i++){
                u=times[i-1][0];
                edgesIndex[i]=head[u];
                head[u]=i;
            }

            boolean[] vis=new boolean[n+1];
            int[] dp=new int[n+1];
            Arrays.fill(dp,Integer.MAX_VALUE);
            dp[k]=0;

            PriorityQueue<int[]> q=new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1]-o2[1];
                }
            });
            q.add(new int[]{k,0});
            int ed,w;
            int[] node;
            while(!q.isEmpty()){
                node=q.poll();
                u=node[0];
                if(vis[u]) continue;
                vis[u]=true;
                ed=head[u];
                while(ed!=0){
                    v=times[ed-1][1];
                    w=times[ed-1][2];
                    if(dp[v]>dp[u]+w){
                        dp[v]=dp[u]+w;
                        q.add(new int[]{v,dp[v]});
                    }
                    ed=edgesIndex[ed];
                }
            }

            int ans=0;
            for(int i=1;i<=n;i++)
                ans=Math.max(ans,dp[i]);
            return ans==Integer.MAX_VALUE?-1:ans;
        }
    }
    
}
