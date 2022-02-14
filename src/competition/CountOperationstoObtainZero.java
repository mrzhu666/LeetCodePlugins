package competition;

import java.util.*;
import java.lang.*;

public class CountOperationstoObtainZero {
    public static void main (String[] args){
        Solution solution = new CountOperationstoObtainZero().new Solution();
        System.out.println(solution);
    }
    
    class Solution {
        public int countOperations(int num1, int num2) {
            int ans=0;
            
            for(;num1!=0 && num2!=0;ans++){
                if(num1>=num2)
                    num1-=num2;
                else
                    num2-=num1;
            }
            
            return ans;
        }
    }
    
}
