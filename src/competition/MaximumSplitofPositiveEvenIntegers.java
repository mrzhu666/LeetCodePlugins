package competition;

import java.util.*;
import java.lang.*;

public class MaximumSplitofPositiveEvenIntegers {
    public static void main(String[] args) {
        
    }
    class Solution {
        public List<Long> maximumEvenSplit(long finalSum) {
            List<Long> ans=new ArrayList<>();
            if(finalSum%2==1) return ans;
            ans.add(2L);
            finalSum-=2;
            for(long i=4;i<=finalSum;i+=2){
                ans.add(i);
                finalSum-=i;
            }
            long tmp=ans.get(ans.size()-1);
            ans.remove(ans.size()-1);
            ans.add(tmp+finalSum);
            return ans;
        }
    }
}