package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class LongestConsecutiveSequence {
    public static void main (String[] args){
        Solution solution = new LongestConsecutiveSequence().new Solution();
        System.out.println(solution);
    }
    class UnionFind{
        HashMap<Integer,Integer> parent=new HashMap<>();
        HashMap<Integer,Integer> size=new HashMap<>();
        UnionFind(int[] nums){
            for(int v:nums){
                parent.put(v,v);
                size.put(v,1);
            }
        }
        public Integer find(int x){
            if(!parent.containsKey(x))
                return null;
            while(x!=parent.get(x)){
                parent.put(x,parent.get(parent.get(x)));
                x=parent.get(x);
            }
            return x;
        }
        public int merge(int x,int y){
            x=find(x);
            y=find(y);
            if(x==y) return size.get(x);
            parent.put(x,y);
            return size.merge(y,size.get(x),Integer::sum);
        }
    }

    class Solution {
        public int longestConsecutive(int[] nums) {
            if(nums.length==0) return 0;
            UnionFind uf=new UnionFind(nums);
            int ans=1;
            Integer p;
            for(int v:nums)
                if((p=uf.find(v+1))!=null)
                    ans=Math.max(ans,uf.merge(v,p));
            return ans;
        }
    }
    
}
