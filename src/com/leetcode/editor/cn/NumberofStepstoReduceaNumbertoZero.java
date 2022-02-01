package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class NumberofStepstoReduceaNumbertoZero {
    public static void main (String[] args){
        Solution solution = new NumberofStepstoReduceaNumbertoZero().new Solution();
        System.out.println(solution);
    }
    class Solution {
        public int numberOfSteps(int num) {
            if(num==0) return 0;
            int n=0,one=0;
            for(;num!=0;num>>=1,n++)
                if((num&1)==1)
                    one++;
            return n+one-1;
//            int ans=0;
//            while(num!=0){
//                ans++;
//                if((num&1)==1)
//                    num--;
//                else
//                    num/=2;
//            }
//            return ans;
        }
    }
    
}
