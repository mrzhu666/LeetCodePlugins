package competition;

import java.util.*;
import java.lang.*;

public class CountArrayPairsDivisiblebyK {
    public static void main(String[] args) {
        Solution solution=new CountArrayPairsDivisiblebyK().new Solution();
        System.out.println(solution.coutPairs(new int[]{1,2,3,4,5},2));
    }
    
    class Solution {
        public int gcd(int a,int b){
            if(b==0) return a;
            return gcd(b,a%b);
        }
        public long coutPairs(int[] nums, int k) {
            long ans=0;
            List<Integer> divisor=new ArrayList<>();
            HashMap<Integer,Integer> divisorCount=new HashMap<>();
            for(int i=1;i<=Math.sqrt(k);i++){
                if(k%i==0){
                    divisor.add(i);
                    divisor.add(k/i);
                    divisorCount.putIfAbsent(i,0);
                    divisorCount.putIfAbsent(k/i,0);
                }
            }
            if(divisor.get(divisor.size()-1).equals(divisor.get(divisor.size()-2)))
                divisor.remove(divisor.size()-1);
            for(int v:nums){
                int g=gcd(v,k);
                ans+=divisorCount.getOrDefault(k/g,0);
                for(int div:divisor){
                    if(v%div==0)
                        divisorCount.merge(div,1,Integer::sum);
                }
            }
            
            return ans;
        }
    }
    
}