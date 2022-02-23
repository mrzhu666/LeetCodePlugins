package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class PushDominoes2 {
    public static void main(String[] args) {
        Solution solution = new PushDominoes2().new Solution();
        System.out.println(solution.pushDominoes("R.R.L"));
    }
    
    class Solution {
        public void push(char[] ans, int left, int right, char leftCh, char rightCh) {
            if (leftCh == 'R' && rightCh == 'R') {
                for (; left < right; left++)
                    ans[left] = 'R';
            } else if (leftCh == 'L' && rightCh == 'L') {
                for (; left < right; right--)
                    ans[right] = 'L';
            } else if (leftCh == 'R' && rightCh == 'L') {
                for (; left < right; right--, left++) {
                    ans[right] = 'L';
                    ans[left] = 'R';
                }
                
            }
        }
        
        public String pushDominoes(String dominoes) {
            int n = dominoes.length();
            char[] ch = dominoes.toCharArray();
            int left = -1, right;
            // left=-1 相当于没初始化
            //
            for (int i = 0; i < n ; i++) {
                if (i!=0 && ch[i] != '.' && ch[i - 1] == '.' && left!=-1) {
                    right = i;
                    if (!(ch[left] == 'L' && ch[right] == 'R')) {
                        right--;left++;
                        for (; left <= right; right--, left++) {
                            // 竖立牌的情况
                            if(left==right && ch[left-1]!=ch[right+1]) break;
                            ch[right] = ch[right+1];
                            ch[left] = ch[left-1];
                        }
                    }
                }
                if (i!=n-1 && ch[i] != '.' && ch[i + 1] == '.') {
                    left = i;
                }
            }
            // 开头倒塌
            for(int i=0;i<n;i++){
                if(ch[i]!='.'){
                    if(ch[i]=='L')
                        for(int j=i-1;j>=0;j--)
                            ch[j]='L';
                    break;
                }
            }
            // 结尾倒塌
            for(int i=n-1;i>=0;i--){
                if(ch[i]!='.'){
                    if(ch[i]=='R')
                        for(int j=i+1;j<n;j++)
                            ch[j]='R';
                    break;
                }
            }
            
            return String.valueOf(ch);
        }
    }
    
}