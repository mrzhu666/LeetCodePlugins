package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

//
//class DetectSquares {
//    static int N=1001;
//    int[][] coor;
//    public DetectSquares() {
//        coor=new int[N][N];
//    }
//
//    public void add(int[] point) {
//        coor[point[0]][point[1]]++;
//    }
//
//    public int count(int[] point) {
//        int ans=0,value;
//        for(int y=Math.min(point[0],point[1]);y)
//        return ans;
//    }
//}


class DetectSquares {
    Map<Integer,Map<Integer,Integer>> coor;
    public DetectSquares() {
        coor=new HashMap<>();
    }

    public void add(int[] point) {
        coor.computeIfAbsent(point[0],s->new HashMap<>());
        coor.get(point[0]).merge(point[1],1,Integer::sum);
    }

    public int count(int[] point) {
        int x0=point[0];
        int y0=point[1];
        Map<Integer,Integer> entrySet=coor.get(x0);
        if(entrySet==null) return 0;
        int ans=0,len,y1;
        Map<Integer,Integer> x3;
        // 垂直点迭代
        for(Map.Entry<Integer,Integer> i:entrySet.entrySet()){
            y1=i.getKey();
            if(y1==y0) continue;
            len=Math.abs(y1-y0);
            // 左边两个点
            x3=coor.getOrDefault(x0-len,null);
            if(x3!=null)
                ans+=i.getValue()*x3.getOrDefault(y1,0)*x3.getOrDefault(y0,0);
            // 右边两个点
            x3=coor.getOrDefault(x0+len,null);
            if(x3!=null)
                ans+=i.getValue()*x3.getOrDefault(y1,0)*x3.getOrDefault(y0,0);
        }
        return ans;
    }
}


