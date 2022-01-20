package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class StoneGameIX {
  public static void main (String[] args){
    Solution solution = new StoneGameIX().new Solution();
    System.out.println(solution);
  }

  class Solution {
    public boolean stoneGameIX(int[] stones) {
      int[] nums=new int[3];
      for(int v:stones)
        nums[v%3]++;

      if(nums[0]%2==0){
        if(nums[1]>=1 && nums[2]>=1)
          return true;
        return false;
      }

      return Math.abs(nums[1]-nums[2])>2;
    }
  }
  
}
