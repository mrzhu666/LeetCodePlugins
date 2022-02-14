package competition;

import java.util.*;
import java.lang.*;

public class RemovingMinimumNumberofMagicBeans {
    public static void main (String[] args){
        Solution solution = new RemovingMinimumNumberofMagicBeans().new Solution();
        System.out.println(solution);
    }
    
    class Solution {
        public long minimumRemoval(int[] beans) {
            long ans=Long.MAX_VALUE;
            int n=beans.length;
            long[] pre=new long[n+1];
            Arrays.sort(beans);
            
            for(int i=1;i<=n;i++)
                pre[i]=pre[i-1]+beans[i-1];
            for(int i=1;i<=n;i++)
                ans=Math.min(ans,pre[i-1]+pre[n]-pre[i]-beans[i-1]*(long)(n-i));
            
            
            return ans;
        }
    }
    
}
