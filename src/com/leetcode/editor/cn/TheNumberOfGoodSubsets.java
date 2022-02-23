package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;
import DataStructure.*;


public class TheNumberOfGoodSubsets{
  public static void main(String[] args) {
    Solution solution = new TheNumberOfGoodSubsets().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfGoodSubsets(int[] nums) {
        int mod=(int)1e9+7;
        int[] p=new int[]{2,3,5,7,11,13,17,19,23,29};
        int[] cnt=new int[31];
        for(int v:nums)
            cnt[v]++;
        int mask=1<<10;
        long[] dp=new long[mask];
        dp[0]=1;
        for(int i=2;i<=30;i++){
            if(cnt[i]==0) continue;
            int cur=0,x=i;
            boolean ok=true;
            for(int j=0;j<10;j++){
                // 判断是否有该质数
                if(i%p[j]!=0) continue;
                int c=0;
                while(x%p[j]==0){
                    x/=p[j];c++;
                }
                if(c==1){
                    cur+=1<<j;
                }else if(c>1){
                    ok=false;
                    break;
                }
            }
            if(!ok) continue;
            for(int prev=mask-1;prev>=0;prev--){
                if((prev&cur)==0)
                    dp[prev|cur]=(dp[prev|cur]+dp[prev]*cnt[i]%mod)%mod;
            }
        }
        long ans=0;
        for(int i=1;i<mask;i++) ans=(ans+dp[i])%mod;
        for(int i=0;i<cnt[1];i++) ans=ans*2%mod;
        return (int)ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}