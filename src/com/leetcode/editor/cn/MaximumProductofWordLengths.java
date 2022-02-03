package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class MaximumProductofWordLengths {
    public static void main (String[] args){
        Solution solution = new MaximumProductofWordLengths().new Solution();
        System.out.println(solution);
    }

    class Solution {
        public int maxProduct(String[] words) {
            int n=words.length;
            int[] letters=new int[n];
            int[] len=new int[n];
            for(int i=0;i<n;i++){
                int tmp=0;
                len[i]=words[i].length();
                for(int j=0;j<len[i];j++)
                    tmp|=1<<(words[i].charAt(j)-'a');
                letters[i]=tmp;
            }
            int ans=0;
            for(int i=1;i<n;i++)
                for(int j=0;j<i;j++)
                    if((letters[i]&letters[j])==0)
                        ans=Math.max(ans,len[i]*len[j]);
            return ans;
        }
    }

}
