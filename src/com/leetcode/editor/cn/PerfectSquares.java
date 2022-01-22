package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class PerfectSquares {
    public static void main (String[] args){
        Solution solution = new PerfectSquares().new Solution();
        System.out.println(solution);
    }

    class Solution {
        public int numSquares(int n) {
            int[] dp=new int[n+1];
            Arrays.fill(dp,n);
            dp[0]=0;
            int squ=(int)Math.sqrt(n);
            for(int i=squ;i>0;i--){
                for(int j=i*i;j<=n;j++){
                    dp[j]=Math.min(dp[j],dp[j-i*i]+1);
                }
            }
            return dp[n];
        }
    }
    
}
