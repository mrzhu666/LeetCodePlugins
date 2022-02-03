package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class ReversePrefixofWord {
    public static void main (String[] args){
        Solution solution = new ReversePrefixofWord().new Solution();
        System.out.println(solution);
    }

    class Solution {
        public String reversePrefix(String word, char ch) {
            int n=word.length();
            int end=0;
            StringBuilder str=new StringBuilder();
            for(;end<n;end++){
                if(word.charAt(end)==ch)
                    break;
            }
            if(end==n || end==0) return word;
            for(int i=end;i>=0;i--)
                str.append(word.charAt(i));
            return str.toString()+word.substring(end+1,n);
        }
    }
}
