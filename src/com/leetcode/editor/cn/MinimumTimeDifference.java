package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class MinimumTimeDifference {
  public static void main(String[] args){
    Solution solution = new MinimumTimeDifference().new Solution();
    System.out.println(solution.findMinDifference(Arrays.asList("23:59","00:00")));
  }

  class Solution {
    public int findMinDifference(List<String> timePoints) {
      int n=timePoints.size();
      int[] time=new int[n];

      for(int i=0;i<n;i++){
        String[] times=timePoints.get(i).split(":");
        int value=Integer.parseInt(times[1]);
        value+=Integer.parseInt(times[0])*60;
        time[i]=value;
      }
      Arrays.sort(time);
      int ans=time[0]-time[n-1]+1440;
      for(int i=1;i<n;i++){
        ans=Math.min(time[i]-time[i-1],ans);
      }
      System.out.println(Arrays.toString(time));
      return ans;
    }
  }
  
}
