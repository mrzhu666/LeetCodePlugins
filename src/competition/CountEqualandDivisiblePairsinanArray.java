package competition;

import java.util.*;
import java.lang.*;

public class CountEqualandDivisiblePairsinanArray {
    public static void main(String[] args) {
        
    }
    class Solution {
        public int countPairs(int[] nums, int k) {
            int n=nums.length;
            int ans=0;
            for(int i=0;i<n;i++)
                for(int j=i+1;j<n;j++)
                    if(nums[i]==nums[j] && (i*j%k)==0)
                        ans++;
            return ans;
        }
    }
}