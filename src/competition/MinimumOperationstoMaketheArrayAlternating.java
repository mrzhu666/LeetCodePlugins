package competition;

import java.util.*;
import java.lang.*;

public class MinimumOperationstoMaketheArrayAlternating {
    public static void main (String[] args){
        Solution solution = new MinimumOperationstoMaketheArrayAlternating().new Solution();
        System.out.println(solution);
    }
    
    class Solution {
        public void getMax(int[] storage,HashMap<Integer,Integer> target){
            for(Map.Entry<Integer,Integer> entry:target.entrySet()){
                if(storage[1]<entry.getValue()){
                    storage[3]=storage[1];
                    storage[2]=storage[0];
                    storage[1]=entry.getValue();
                    storage[0]=entry.getKey();
                }else if(storage[3]<entry.getValue()){
                    storage[3]=entry.getValue();
                    storage[2]=entry.getKey();
                }
            }
        }
        public int minimumOperations(int[] nums) {
            int n=nums.length;
            HashMap<Integer,Integer> cntOdd=new HashMap<>();
            HashMap<Integer,Integer> cntEven=new HashMap<>();
            for(int i=0;i<n;i+=2){
                cntOdd.merge(nums[i],1,Integer::sum);
            }
            for(int i=1;i<n;i+=2){
                cntEven.merge(nums[i],1,Integer::sum);
            }
            int[] oddMax=new int[4];
            int[] evenMax=new int[4];
            
            getMax(oddMax,cntOdd);
            getMax(evenMax,cntEven);
            
            if(evenMax[0]!=oddMax[0]){
                return n-evenMax[1]-oddMax[1];
            }else{
                return n-Math.max(evenMax[1]+oddMax[3],evenMax[3]+oddMax[1]);
            }
            
        }
    }
    
}
