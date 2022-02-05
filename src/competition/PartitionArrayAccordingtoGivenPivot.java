package competition;

import java.util.*;
import java.lang.*;

public class PartitionArrayAccordingtoGivenPivot {
    public static void main (String[] args){
        Solution solution = new PartitionArrayAccordingtoGivenPivot().new Solution();
        System.out.println(solution);
    }
    
    class Solution {
        public int[] pivotArray(int[] nums, int pivot) {
            int n=nums.length;
            int[] ans=new int[n];
            int p=0;
            int equNum=0;
            for(int i=0;i<n;i++){
                if(nums[i]==pivot) equNum++;
                if(nums[i]<pivot) ans[p++]=nums[i];
            }
            for(int i=0;i<equNum;i++)
                ans[p++]=pivot;
            for(int i=0;i<n;i++)
                if(nums[i]>pivot)
                    ans[p++]=nums[i];
            return ans;
        }
    }
    
}
