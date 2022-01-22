package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class CombinationSumIV {
    public static void main (String[] args){
        Solution solution = new CombinationSumIV().new Solution();
        System.out.println(solution);
    }

    class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] dp=new int[target+1];
            dp[0]=1;
            for(int i=1;i<=target;i++)
                for(int num:nums)
                    if(i>=num)
                        dp[i]+=dp[i-num];
            return dp[target];
        }
    }
    
}
