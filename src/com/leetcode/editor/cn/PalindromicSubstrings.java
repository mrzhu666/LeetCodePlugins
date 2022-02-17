package com.leetcode.editor.cn;

//Given a string s, return the number of palindromic substrings in it. 
//
// A string is a palindrome when it reads the same backward as forward. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
// 
//
// Example 2: 
//
// 
//Input: s = "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of lowercase English letters. 
// 
// Related Topics 字符串 动态规划 👍 776 👎 0


import java.util.*;
import java.lang.*;

public class PalindromicSubstrings {
    public static void main (String[] args){
        Solution solution = new PalindromicSubstrings().new Solution();
        System.out.println(solution);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        int ans=1,n=s.length();
        
        if(n!=1 && s.charAt(0)==s.charAt(1)) ans++;
        
        int j;
        for(int i=1;i<n;i++){
            j=1;
            for(;i-j>=0 && i+j<=n-1 && s.charAt(i-j)==s.charAt(i+j);j++);
            ans+=j;
            j=1;
            for(;i-j+1>=0 && i+j<=n-1 && s.charAt(i-j+1)==s.charAt(i+j);j++);
            ans+=j-1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}

