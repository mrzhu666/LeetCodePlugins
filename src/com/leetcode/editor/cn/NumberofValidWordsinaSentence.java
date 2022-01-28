package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;



public class NumberofValidWordsinaSentence {
    public static void main (String[] args){
        Solution solution = new NumberofValidWordsinaSentence().new Solution();
        System.out.println(solution.countValidWords("!g 3 !sy "));
    }

    class Solution {
        public int countValidWords(String sentence) {
            int ans=0;
            String[] strings=sentence.split(" ");
            for(String s:strings)
                if(check(s))
                    ans++;
            return ans;
        }
        public boolean check(String str){
            int n=str.length();
            char ch;
            if(n==0) return false;
            // c1 连字符数量，c2标点符数量
            for(int i=0,c1=0,c2=0;i<n;i++){
                ch=str.charAt(i);
                if(ch==' ') return false;
                if(Character.isDigit(ch)) return false;
                if(ch=='-'){
                    if(c1>0 || i==0 || i==n-1) return false;
                    if(!(Character.isLetter(str.charAt(i-1)) && Character.isLetter(str.charAt(i+1))))
                        return false;
                    c1++;
                }else if(ch=='.' || ch=='!' || ch==','){
                    if(c2>0 || i!=n-1) return false;
                    c2++;
                }
            }
            return true;
        }
    }
    // 屎山代码，越写越复杂，
    // 没有用函数传递，变量标志位初始化麻烦
    class Solution1 {
        public int countValidWords(String sentence) {
            int n=sentence.length(),ans=0;
            char[] ch=sentence.toCharArray();
            // numBool 数字是否出现过，lastPun 上一个字符是否是符号hyp，hyp 连字符是否合法
            // punNum 符号数量，hypNum 连字符数量
            boolean numBool=false,lastPun=false,hyp=true,lastSpace=false;
            int punNum=0,hypNum=0;
            for(int i=0;i<n;i++){
                if(ch[i]==' '){
                    if(lastSpace)
                        continue;
                    if(!numBool && hyp && hypNum<=1 && (punNum==0 || (punNum==1 && lastPun)))
                        ans++;
                    numBool=false;
                    lastPun=false;
                    punNum=0;
                    hyp=true;
                    hypNum=0;
                    lastSpace=true;
                    continue;
                }

                if(Character.isDigit(ch[i])){
                    numBool=true;
                    lastPun=false;
                }
                else if(ch[i]=='!'||ch[i]=='.'||ch[i]==',') {
                    lastPun = true;
                    punNum++;
                }else if(hyp && ch[i]=='-'){
                    lastPun=false;
                    if(i==0 || i==n-1)
                        hyp=false;
                    else if(Character.isLetter(ch[i-1]) && Character.isLetter(ch[i+1])){
                        hyp=true;
                        hypNum++;
                    }
                    else
                        hyp=false;
                }else
                    lastPun=false;
                lastSpace=false;
            }
            if(!numBool && hyp && hypNum<=1 && (punNum==0 || (punNum==1 && lastPun)))
                ans++;
            return ans;
        }
    }

}
