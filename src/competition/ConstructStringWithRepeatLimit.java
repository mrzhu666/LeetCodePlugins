package competition;

import java.util.*;
import java.lang.*;

public class ConstructStringWithRepeatLimit {
    public static void main(String[] args) {
        
    }
    
    class Solution {
        public String repeatLimitedString(String s, int repeatLimit) {
            StringBuilder ans=new StringBuilder();
            int[] letter=new int[26];
            for(char ch:s.toCharArray())
                letter[ch-'a']++;
            for(int i=25;i>=0;i--){
                while(letter[i]!=0){
                    if(letter[i]<=repeatLimit){
                        for(int j=0;j<letter[i];j++)
                            ans.append((char)(i+'a'));
                        letter[i]=0;
                    }else{
                        for(int j=0;j<repeatLimit;j++)
                            ans.append((char)(i+'a'));
                        letter[i]-=repeatLimit;
                        for(int j=i-1;j>=0;j--)
                            if(letter[j]!=0){
                                ans.append((char)(j+'a'));
                                letter[j]--;
                                break;
                            }
                        if(ans.charAt(ans.length()-1)-'a'==i)
                            break;
                    }
                }
            }
            return ans.toString();
        }
    }
    
}