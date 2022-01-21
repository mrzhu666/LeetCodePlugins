package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class NonoverlappingIntervals {
    public static void main (String[] args){
        Solution solution = new NonoverlappingIntervals().new Solution();
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}}));
    }

    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            int n=intervals.length;
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1]!=o2[1])
                        return o1[1]-o2[1];
                    return o1[0]-o2[0];
                }
            });
            int ans=0;
            int end=intervals[0][1];
            for(int i=1;i<n;i++){
                if(end<=intervals[i][0]){
                    end=intervals[i][1];
                }else{
                    ans++;
                }
            }
            return ans;
        }
    }
    class Solution1 {
        public int eraseOverlapIntervals(int[][] intervals) {
            int n=intervals.length;
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0]!=o2[0])
                        return o1[0]-o2[0];
                    return o1[1]-o2[1];
                }
            });
            int ans=1;
            int end=intervals[0][1];
            for(int i=1;i<n;i++){
                if(end>intervals[i][0]){
                    if(end>intervals[i][1])
                        end=intervals[i][1];
                }else{
                    end=intervals[i][1];
                    ans++;
                }
            }
            return n-ans;
        }
    }
    
}
