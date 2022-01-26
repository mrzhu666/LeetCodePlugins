package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class SecondMinimumTimetoReachDestination {
    public static void main(String[] args) {
        Solution solution = new SecondMinimumTimetoReachDestination().new Solution();
        System.out.println(solution.secondMinimum(6, new int[][]{{1, 2}, {1, 3}, {2, 4}, {3, 5}, {5, 4}, {4, 6}}, 3, 100));
    }

    class Solution {
        int cnt = 0;
        int[] head;
        int[] edgesIndex;

        public void add(int u, int v) {
            cnt++;
            edgesIndex[cnt] = head[u];
            head[u] = cnt;
        }

        public int secondMinimum(int n, int[][] edges, int time, int change) {
            int m = edges.length;
            head = new int[n + 1];
            edgesIndex = new int[2 * m + 1];
            for (int i = 1; i <= m; i++) {
                add(edges[i-1][0], edges[i-1][1]);
                add(edges[i-1][1], edges[i-1][0]);
            }

            int[][] dp = new int[2][n + 1];
            Arrays.fill(dp[0], 0x3f3f3f3f);
            Arrays.fill(dp[1], 0x3f3f3f3f);
            dp[0][1] = 0;
            int[] node;
            int ed, u, v, cur, wait, w;
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{1, 0});
            while (!q.isEmpty()) {
                node = q.poll();
                u = node[0];
                cur = node[1];
                ed = head[u];
                if (cur / change % 2 == 1)
                    wait = (cur / change + 1) * change - cur;
                else
                    wait = 0;
                w = cur + wait + time;
                while (ed != 0) {
                    v = u == edges[(ed + 1) / 2 - 1][0] ? edges[(ed + 1) / 2 - 1][1] : edges[(ed + 1) / 2 - 1][0];
                    if (dp[0][v] > w) {
                        dp[0][v] = w;
                        q.add(new int[]{v, w});
                    } else if (dp[1][v] > w && w > dp[0][v]) {
                        dp[1][v] = w;
                        q.add(new int[]{v, w});
                    }
                    ed = edgesIndex[ed];
                }
            }
            return dp[1][n];
        }
    }


    class Solution2 {
        int cnt = 0;
        int[] edgesIndex;
        int[] head;

        public void add(int u, int v) {
            cnt++;
            edgesIndex[cnt] = head[u];
            head[u] = cnt;
        }

        public int secondMinimum(int n, int[][] edges, int time, int change) {
            int m = edges.length;
            edgesIndex = new int[2 * m + 1];  // 存储下一条边索引
            head = new int[n + 1];
            int u, v;
            for (int i = 1; i <= m; i++) {
                add(edges[i - 1][0], edges[i - 1][1]);
                add(edges[i - 1][1], edges[i - 1][0]);
            }
            int[] dp1 = new int[n + 1];  // 最短
            int[] dp2 = new int[n + 1];  // 第二短
            Arrays.fill(dp1, 0x3f3f3f3f);
            Arrays.fill(dp2, 0x3f3f3f3f);
            PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });
            dp1[1] = 0;
            q.add(new int[]{1, 0});
            int ed, cur, wait, w;
            int[] node;
            while (!q.isEmpty()) {
                node = q.poll();
                u = node[0];
                cur = node[1];
                if (cur / change % 2 == 1)
                    wait = (cur / change + 1) * change - cur;
                else
                    wait = 0;
                w = cur + wait + time;
                ed = head[u];
                while (ed != 0) {
                    v = edges[(ed + 1) / 2 - 1][0] == u ? edges[(ed + 1) / 2 - 1][1] : edges[(ed + 1) / 2 - 1][0];

                    if (dp1[v] > w) {
                        dp2[v] = dp1[v];
                        dp1[v] = w;
                        q.add(new int[]{v, dp1[v]});
                    } else if (dp2[v] > w && w > dp1[v]) {
                        dp2[v] = w;
                        q.add(new int[]{v, dp2[v]});
                    }

                    ed = edgesIndex[ed];
                }
            }
            return dp2[n];
        }
    }

    class Solution1 {
        int m;
        int n;
        int[] edgesIndex;
        int[] head;
        int[][] edges;
        int[][] dp;
        int change;
        int time;

        public int secondMinimum(int n, int[][] edges, int time, int change) {
            this.n = n;
            this.edges = edges;
            this.change = change;
            this.time = time;
            m = edges.length;
            edgesIndex = new int[2 * m + 1];  // 存储下一条边索引
            head = new int[n + 1];
            int u, v;
            for (int i = 1; i <= m; i++) {
                u = edges[i - 1][0];
                v = edges[i - 1][1];
                edgesIndex[2 * i - 1] = head[u];
                head[u] = 2 * i - 1;
                edgesIndex[2 * i] = head[v];
                head[v] = 2 * i;
            }
            dp = new int[n + 1][2];
            for (int i = 1; i <= n; i++)
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            dfs(1, 0);
            // 0是第二小，1是第一小
            return dp[n][0];
        }

        /**
         * @param u   当前节点
         * @param cur 到达此节点时时间
         */
        public void dfs(int u, int cur) {
            if (dp[u][1] == cur)
                return;
            else if (dp[u][1] > cur) {
                dp[u][0] = dp[u][1];
                dp[u][1] = cur;
            } else if (dp[u][0] > cur)
                dp[u][0] = cur;
            else
                return;
            int ed, v, wait = 0;
            // [(2k-1)change,2k*change) 红灯
            if (cur / change % 2 == 1)
                wait = (cur / change + 1) * change - cur;  // 等待时间

            ed = head[u];
            while (ed != 0) {
                v = edges[(ed + 1) / 2 - 1][0] == u ? edges[(ed + 1) / 2 - 1][1] : edges[(ed + 1) / 2 - 1][0];
                dfs(v, cur + wait + time);
                ed = edgesIndex[ed];
            }
        }
    }
}
