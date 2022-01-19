package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class ContainsDuplicateII {
  public static void main (String[] args){
    Solution solution = new ContainsDuplicateII().new Solution();
    System.out.println(solution);
  }
  
  class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
      int n = nums.length;
      Set<Integer> set = new HashSet<>();
      for(int i=0;i<n;i++) {
        if(i>k)
          set.remove(nums[i-k-1 ]);
        if(set.contains(nums[i]))
          return true;
        set.add(nums[i]);
      }
      return false;
    }
  }
  
}
