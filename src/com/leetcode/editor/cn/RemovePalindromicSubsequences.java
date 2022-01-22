package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class RemovePalindromicSubsequences {
    public static void main (String[] args){
        Solution solution = new RemovePalindromicSubsequences().new Solution();
        System.out.println(solution);
    }

    class Solution {
        public int removePalindromeSub(String s) {
            int n=s.length();
            for(int i=0;i<n/2;i++){
                if(s.charAt(i)!=s.charAt(n-1-i))
                    return 2;
            }
            return 1;
        }
    }
    
}
