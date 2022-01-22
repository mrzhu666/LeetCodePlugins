package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class CoinChange2 {
    public static void main (String[] args){
        Solution solution = new CoinChange2().new Solution();
        System.out.println(solution.change(5,new int[]{1,2,5}));
    }

    class Solution {
        public int change(int amount, int[] coins) {
            int[] dp=new int[amount+1];
            dp[0]=1;
            for (int coin : coins)
                for(int i=coin;i<=amount;i++)
                    if (i >= coin)
                        dp[i] += dp[i-coin];
            System.out.println(Arrays.toString(dp));
            return dp[amount];
        }
    }
    
}
