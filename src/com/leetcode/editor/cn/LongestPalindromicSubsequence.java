package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class LongestPalindromicSubsequence {
  public static void main (String[] args){
    Solution solution = new LongestPalindromicSubsequence().new Solution();
    System.out.println(solution.longestPalindromeSubseq("aaebcbeee"));
  }

  class Solution {
    public int longestPalindromeSubseq(String s) {
      int n=s.length();
      char[] ch=s.toCharArray();
      int[] dp=new int[n];
      Arrays.fill(dp,1);
      int max=1;  // i-1为结尾时最长子序列长度
      for(int i=1;i<n;i++){
        max=1;
        if(ch[i]==ch[i-1]) dp[i-1]=2;  // 特别处理
        for(int j=i-2;j>=0;j--){
          int tmp=dp[j];
          if(ch[i]==ch[j]){
            dp[j]=max+2;
          }
          max=Math.max(tmp,max);
        }
      }
      int ans=1;
      for(int i=0;i<n;i++){
        ans=Math.max(ans,dp[i]);
      }
      return ans;
    }
  }
  
}
