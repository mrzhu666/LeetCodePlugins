package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class LongestNiceSubstring {
    public static void main (String[] args){
        Solution solution = new LongestNiceSubstring().new Solution();
        System.out.println(solution);
    }

    class Solution {
        public String longestNiceSubstring(String s) {
            int n=s.length();
            char[] ch=s.toCharArray();
            int maxLen=0,index=0;
            int lower,upper;

            for(int i=0;i<n;i++){
                lower=0;
                upper=0;
                for(int j=i;j<n;j++){
                    if(Character.isLowerCase(ch[j]))
                        lower|=1<<(ch[j]-'a');
                    if(Character.isUpperCase(ch[j]))
                        upper|=1<<(ch[j]-'A');
                    if((upper^lower)==0 && (j-i+1)>maxLen){
                        index=i;
                        maxLen=j-i+1;
                    }
                }
            }
            return s.substring(index,index+maxLen);
        }
    }
    
}
