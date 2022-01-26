package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class CountofMatchesinTournament {
    public static void main (String[] args){
        Solution solution = new CountofMatchesinTournament().new Solution();
        System.out.println(solution);
    }

    class Solution {
        public int numberOfMatches(int n) {
            int ans=0;
            while(n!=1){
                ans+=n/2;
                n=(n+1)/2;
            }
            return ans;
        }
    }
    
}
