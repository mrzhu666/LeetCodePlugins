package competition;

import java.util.*;
import java.lang.*;

public class CountIntegersWithEvenDigitSum {
    public static void main(String[] args) {
        
    }
    class Solution {
        public int countEven(int num) {
            int ans=0;
            for(int i=2;i<=num;i++){
                if(count(i))
                    ans++;
            }
            return ans;
        }
        public boolean count(int num){
            int res=0;
            while(num!=0){
                res+=num%10;
                num/=10;
            }
            return (res&1)==0;
        }
    }
}