package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class UncommonWordsfromTwoSentences {
    public static void main (String[] args){
        Solution solution = new UncommonWordsfromTwoSentences().new Solution();
        System.out.println(solution.uncommonFromSentences("this apple is sweet", "this apple is sour"));
    }

    class Solution {
        public String[] uncommonFromSentences(String s1, String s2) {
            Set<String> ans=new HashSet<>();
            Set<String> remove=new HashSet<>();
            for(String s:s1.split(" ")){
                if(ans.contains(s)){
                    remove.add(s);
                    ans.remove(s);
                }else if(!remove.contains(s)){
                    ans.add(s);
                }
            }
            for(String s:s2.split(" ")){
                if(ans.contains(s)){
                    remove.add(s);
                    ans.remove(s);
                }else if(!remove.contains(s)){
                    ans.add(s);
                }
            }
            return ans.toArray(new String[0]);
        }
    }
    class Solution1 {
        public String[] uncommonFromSentences(String s1, String s2) {
            List<String> ans=new ArrayList<>();
            Set<String> setS1=new HashSet<>();
            Set<String> setS1Tmp=new HashSet<>();
            Set<String> setS2=new HashSet<>();
            Set<String> setS2Tmp=new HashSet<>();
            for(String s:s1.split(" ")){
                if(setS1Tmp.contains(s)) continue;
                if(setS1.contains(s)){
                    setS1Tmp.add(s);
                    setS1.remove(s);
                }else{
                    setS1.add(s);
                }
            }
            for(String s:s2.split(" ")){
                if(setS2Tmp.contains(s)) continue;
                if(setS2.contains(s)){
                    setS2Tmp.add(s);
                    setS2.remove(s);
                }else{
                    setS2.add(s);
                }
            }

            for(String s:setS1)
                if(!setS2.contains(s) && !setS2Tmp.contains(s))
                    ans.add(s);
            for(String s:setS2)
                if(!setS1.contains(s) && !setS1Tmp.contains(s))
                    ans.add(s);

            return ans.toArray(new String[0]);
        }
    }

}
