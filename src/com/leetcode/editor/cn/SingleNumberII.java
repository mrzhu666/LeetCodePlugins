package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class SingleNumberII {
    public static void main (String[] args){
        Solution solution = new SingleNumberII().new Solution();
        System.out.println(solution);
    }

    class Solution {
        public int singleNumber(int[] nums) {
            Map<Integer,Integer> count=new HashMap<>();
            for(int v:nums){
                count.merge(v,1,Integer::sum);
                if(count.get(v)==3)
                    count.remove(v);
            }
            return count.keySet().toArray(new Integer[0])[0];
        }
    }
    
}
