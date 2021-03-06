package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        System.out.println(solution);
    }
    // dp
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) return 0;
            int n=coins.length;
            int[] dp=new int[amount+1];
            Arrays.fill(dp,Integer.MAX_VALUE);
//            Arrays.sort(coins);
            dp[0]=0;
            for(int i=n-1;i>=0;i--){
                for(int j=coins[i];j<=amount;j++){
                    if(dp[j-coins[i]]+1>0)
                        dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
            return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
        }
    }
    // dfs
    class Solution1 {
        int n;
        int[] dp;

        public int coinChange(int[] coins, int amount) {
            if (amount == 0) return 0;
            n = coins.length;
            dp = new int[amount + 1];  // 某一金钱需要的最少硬币数
            // INF是没初始化，-1是无法到达
            Arrays.fill(dp, Integer.MAX_VALUE);
            for (int i = 0; i < n; i++)
                if (coins[i] <= amount)
                    dp[coins[i]] = 1;
            Arrays.sort(coins);
            return dfs(coins, amount);
        }

        public int dfs(int[] coins, int amount) {
            if (dp[amount] != Integer.MAX_VALUE)
                return dp[amount];
            for (int i = n - 1; i > -1; i--) {
                if (coins[i] > amount)
                    continue;
                int v = dfs(coins, amount - coins[i]);
                if (v != -1)
                    dp[amount] = Math.min(dp[amount], v + 1);
            }
            if (dp[amount] == Integer.MAX_VALUE)
                dp[amount] = -1;
            return dp[amount];
        }
    }

}
