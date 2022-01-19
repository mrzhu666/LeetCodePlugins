package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class WiggleSubsequence {
  public static void main (String[] args){
    Solution solution = new WiggleSubsequence().new Solution();
    System.out.println(solution.wiggleMaxLength(new int[]{0,0}));
  }
  class Solution {
    public int wiggleMaxLength(int[] nums) {
      int n=nums.length;
      if(n==1) return n;

      int up=1,down=1;
      for(int i=1;i<n;i++){
        if(nums[i]>nums[i-1]){
          up=Math.max(up,down+1);
        }else if(nums[i]<nums[i-1]){
          down=Math.max(down,up+1);
        }
      }
      return Math.max(up,down);
    }
  }


  // 不通过，不知原因
  class Solution1 {
    public int wiggleMaxLength(int[] nums) {
      int n=nums.length;
      if(n==1) return n;
      int[] positive=new int[n];
      int[] negetive=new int[n];
      Arrays.fill(positive,-1);
      Arrays.fill(negetive,-1);
      positive[0]=nums[0];
      negetive[0]=nums[0];
      for(int i=1;i<n;i++){
        for(int j=i-1;j>=0;j--){
          if(positive[j]!=-1 && positive[j]>nums[i] && (negetive[j+1]==-1 || negetive[j+1]>nums[j]))
            negetive[j+1]=nums[i];
          if(negetive[j]!=-1 && negetive[j]<nums[i] && (positive[j+1]==-1 || positive[j+1]<nums[j]))
            positive[j+1]=nums[i];
        }
      }
      System.out.println(Arrays.toString(positive));
      System.out.println(Arrays.toString(negetive));
      int i=n-1;
      for(;i>=0;i--){
        if(positive[i]!=-1 || negetive[i]!=-1)
          return i+1;
      }
      return i+1;
    }
  }
  
}
