package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class IsSubsequence {
  public static void main (String[] args){
    Solution solution = new IsSubsequence().new Solution();
    System.out.println(solution.isSubsequence("abc"
            ,"ahbgdc"));
  }

  class Solution {
    public boolean isSubsequence(String s, String t) {
      if(s.length()>t.length())
        return false;
      int n=s.length();
      int m=t.length();
      int i=0,j=0;
      while(i<n && j<m){
        while(j<m && s.charAt(i)!=t.charAt(j))
          j++;
        if(j<m && s.charAt(i)==t.charAt(j)){
          i++;j++;
        }
      }
      return i==n;
    }
  }
  
}
