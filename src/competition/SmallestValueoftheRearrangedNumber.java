package competition;

import java.util.*;
import java.lang.*;

public class SmallestValueoftheRearrangedNumber {
    public static void main (String[] args){
        Solution solution = new SmallestValueoftheRearrangedNumber().new Solution();
        System.out.println(solution.smallestNumber(-2230363001L));
    }
    
    class Solution {
        public long smallestNumber(long num) {
            long ans=0;
            int[] digitals=new int[10];
            if(num>0){
                while(num!=0){
                    int digital=(int)(num%10);
                    digitals[digital]++;
                    num/=10;
                }
                for(int i=1;i<10;i++){
                    if(digitals[i]!=0){
                        ans+=i;
                        digitals[i]--;
                        break;
                    }
                }
                
                for(int i=0;i<10;i++){
                    for(int j=0;j<digitals[i];j++){
                        ans=ans*10+i;
                    }
                }
                
                return ans;
            }else if(num<0){
                num=-num;
                while(num!=0){
                    int digital=(int)(num%10);
                    digitals[digital]++;
                    num/=10;
                }
    
                for(int i=9;i>=0;i--){
                    for(int j=0;j<digitals[i];j++){
                        ans=ans*10+i;
                    }
                }
    
                return -ans;
            }
            
            return ans;
        }
    }
    
}
