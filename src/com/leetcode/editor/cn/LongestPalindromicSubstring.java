//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
// Related Topics 字符串 动态规划 👍 4519 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class
LongestPalindromicSubstring{
  public static void main(String[] args) {
    Solution solution = new LongestPalindromicSubstring().new Solution();
    System.out.print(solution.longestPalindrome("aaaaa"));
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
      int n=s.length();
      if(n==1) return s;
      char[] ch=s.toCharArray();
      int ansl=0;
      int ansr=ch[0]==ch[1]?1:0;
      int i=1 ;
      while(i<n-1){
        int m1=1,m2=1;
        for(;i+m1<n && i-m1+1>=0 && ch[i-m1+1]==ch[i+m1];m1++);
        for(;i+m2<n && i-m2>=0 && ch[i-m2]==ch[i+m2];m2++);
        m1--;m2--;
        if(2*m1>ansr-ansl+1){
          ansl=i-m1+1;ansr=i+m1;
        }
        if(2*m2+1>ansr-ansl+1){
          ansl=i-m2;ansr=i+m2;
        }

        i++;

      }

      return s.substring(ansl,ansr+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//
//class Solution {
//  public int longestPalindromeSubseq(String s) {
//    int n=s.length();
//    int ans=1;
//    char[] ch=s.toCharArray();
////      if(ch[0]==ch[1]) ans=2;
//    for(int i=0;i<n;i++){
//
//      // i为中心
//      int j=1;
//      for(;i-j>=0 && i+j<=n-1 && ch[i-j]==ch[i+j];j++);
//      ans=Math.max(2*(j-1)+1,ans);
//      j=1;
//      for(;i-j+1>=0 && i+j<=n-1 && ch[i-j+1]==ch[i+j];j++);
//      ans=Math.max(2*(j-1),ans);
//    }
//
//    return ans;
//  }