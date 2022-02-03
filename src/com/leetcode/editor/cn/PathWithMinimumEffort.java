package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        Solution solution = new PathWithMinimumEffort().new Solution();
        System.out.println(solution);
    }

    class UnionFind {
        int[] parent;
        int[] effort;

        UnionFind(int n) {
            parent = new int[n];
            effort = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        public void merge(int x, int y, int w) {
            x = find(x);
            y = find(y);
            if (x == y) return;
            parent[x] = y;
            effort[y] = Math.max(effort[y], Math.max(effort[x], w));
        }

    }

    class Solution {
        public int minimumEffortPath(int[][] heights) {
            int n = heights.length;
            int m = heights[0].length;
            UnionFind uf = new UnionFind(n * m);

            PriorityQueue<int[]> q = new PriorityQueue<>(((o1, o2) -> o1[2] - o2[2]));
            int u, v, w;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    u = i * m + j;
                    if (j != m - 1) {
                        v = u + 1;
                        w = Math.abs(heights[i][j] - heights[i][j + 1]);
                        q.add(new int[]{u, v, w});
                    }
                    if (i != n - 1) {
                        v = u + m;
                        w = Math.abs(heights[i][j] - heights[i + 1][j]);
                        q.add(new int[]{u, v, w});
                    }
                }
            }
            int[] tmp;
            while (!q.isEmpty() && uf.find(0) != uf.find(n * m - 1)) {
                tmp = q.poll();
                uf.merge(tmp[0], tmp[1], tmp[2]);
            }

            return uf.effort[uf.find(0)];
        }
    }

}
