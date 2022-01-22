package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class IncreasingTripletSubsequence {
    public static void main (String[] args){
        Solution solution = new IncreasingTripletSubsequence().new Solution();
        System.out.println(solution);
    }

    class Solution {
        public boolean increasingTriplet(int[] nums) {
            int n=nums.length;
            int first=nums[0],second=Integer.MAX_VALUE;
            for(int i=1;i<n;i++){
                if(first>nums[i])
                    first=nums[i];
                else if(first==nums[i])
                    continue;
                else if(second>nums[i])
                    second=nums[i];
                else if(second<nums[i])
                    return true;
            }
            return false;
        }
    }
    
}
