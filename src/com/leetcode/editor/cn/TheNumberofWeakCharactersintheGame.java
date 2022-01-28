package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class TheNumberofWeakCharactersintheGame {
    public static void main (String[] args){
        Solution solution = new TheNumberofWeakCharactersintheGame().new Solution();
        System.out.println(solution.numberOfWeakCharacters(new int[][]{{5,5},{6,3},{3,6}}));
    }

    class Solution {
        public int numberOfWeakCharacters(int[][] properties) {
            int ans=0,n=properties.length;
            Arrays.sort(properties, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0]!=o2[0])
                        return o2[0]-o1[0];
                    else
                        return o1[1]-o2[1];
                }
            });
            int maxDefense=0;
            for(int i=0;i<n;i++){
                if(properties[i][1]<maxDefense)
                    ans++;
                else
                    maxDefense=properties[i][1];
            }
            return ans;
        }
    }

//    class Solution {
//        public int numberOfWeakCharacters(int[][] properties) {
//            Arrays.sort(properties,(o1, o2) -> Integer.compare(o1[0],o2[0]));
//
//            System.out.println(Arrays.deepToString(properties));
//            return 0;
//        }
//
//        public int merge(int[][] properties,int left,int right){
//            int ans=0,mid=(left+right)/2;
//            if(left<right){
//                ans+=merge(properties,left,mid);
//                ans+=merge(properties,mid+1,right);
//                ans+=mergeNum(properties,left,mid,right);
//            }
//            return ans;
//        }
//
//        public int mergeNum(int[][] properties,int left,int mid,int right){
//            int ans=0;
//            int[][] tmp=new int[right-left+1][];
//            for(int p1=left,p2=mid+1;p1<=mid && p2<=right;){
//                if(properties[p1][1]<properties[p2][1]){
//                    p1++;
//                }else if(properties[p1][1]==properties[p2][1]){
//                    p1++;
//                    p2++;
//                    ans++;
//                }else{
//                    p2++;
//                }
//            }
//
//            return ans;
//        }
//    }

}
