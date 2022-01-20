package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class PascalsTriangleII {
  public static void main (String[] args){
    Solution solution = new PascalsTriangleII().new Solution();
    System.out.println(solution);
  }

  class Solution {
    public List<Integer> getRow(int rowIndex) {
      List<Integer> ans=new ArrayList<>();
      ans.add(1);
      // 第i行,从0开始
      for(int i=1;i<=rowIndex;i++){
        for(int j=i-1;j>0;j--){
          ans.set(j,ans.get(j)+ans.get(j-1));
        }
        ans.add(1);
      }
      return ans;
    }
  }
  
}
