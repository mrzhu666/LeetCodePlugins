package competition;

import java.util.*;
import java.lang.*;

public class SortEvenandOddIndicesIndependently {
    public static void main (String[] args){
        Solution solution = new SortEvenandOddIndicesIndependently().new Solution();
        System.out.println(solution);
    }
    
    class Solution {
        public int[] sortEvenOdd(int[] nums) {
            int n=nums.length;
            List<Integer> odd=new ArrayList<>();
            List<Integer> even=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(i%2==0)
                    even.add(nums[i]);
                else
                    odd.add(nums[i]);
            }
            int[] ans=new int[n];
            Collections.sort(odd,Collections.reverseOrder());
            Collections.sort(even);
            for(int i=0;i<n;i++){
                if(i%2==0)
                    ans[i]=even.get(i/2);
                else
                    ans[i]=odd.get(i/2);
            }
            return ans;
        }
    }
    
}
