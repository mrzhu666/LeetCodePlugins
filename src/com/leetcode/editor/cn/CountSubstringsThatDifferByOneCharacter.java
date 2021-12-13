//Given two strings s and t, find the number of ways you can choose a non-empty 
//substring of s and replace a single character by a different character such 
//that the resulting substring is a substring of t. In other words, find the number 
//of substrings in s that differ from some substring in t by exactly one character. 
//
//
// For example, the underlined substrings in "computer" and "computation" only 
//differ by the 'e'/'a', so this is a valid way. 
//
// Return the number of substrings that satisfy the condition above. 
//
// A substring is a contiguous sequence of characters within a string. 
//
// 
// Example 1: 
//
// 
//Input: s = "aba", t = "baba"
//Output: 6
//Explanation: The following are the pairs of substrings from s and t that 
//differ by exactly 1 character:
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//The underlined portions are the substrings that are chosen from s and t.
// 
//Example 2:
//
// 
//Input: s = "ab", t = "bb"
//Output: 3
//Explanation: The following are the pairs of substrings from s and t that 
//differ by 1 character:
//("ab", "bb")
//("ab", "bb")
//("ab", "bb")
//​​​​The underlined portions are the substrings that are chosen from s and t.
// 
//Example 3:
//
// 
//Input: s = "a", t = "a"
//Output: 0
// 
//
// Example 4: 
//
// 
//Input: s = "abe", t = "bbc"
//Output: 10
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 100 
// s and t consist of lowercase English letters only. 
// 
// Related Topics 哈希表 字符串 动态规划 👍 29 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class CountSubstringsThatDifferByOneCharacter{
  public static void main(String[] args) {
    Solution solution = new CountSubstringsThatDifferByOneCharacter().new Solution();
    System.out.print(solution.countSubstrings("abe","bbc"));
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int countSubstrings(String s, String t) {
    int n=s.length();
    int m=t.length();
    int answer=0,diff=0;
    for(int i=0;i<=n;i++)
      for(int j=0;j<=m;j++){
        diff=0;
        for(int k=1;i+k-1<n && j+k-1<m && diff<2;k++){
          if(s.charAt(i+k-1)!=t.charAt(j+k-1)) diff++;
          if(diff==1) answer++;
        }
      }
    return answer;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

// 前缀记忆
class Solution2 {
  public int countSubstrings(String s, String t) {
    int n=s.length();
    int m=t.length();
    int answer=0;
    int diff,k;
    int[][] dp=new int[n][m];
    for(int i=0;i<n;i++)
      for(int j=0;j<m;j++){
        if(dp[i][j]!=0) {
          answer+=dp[i][j];
          continue;
        }
        diff=0;
        k=1;
        for(;i+k-1<n && j+k-1<m && diff<2;k++){
          if(s.charAt(i+k-1)!=t.charAt(j+k-1)) diff++;
          if(diff==1) {
            dp[i][j]++;
            answer++;
          }
        }
        for(int z=1;z<k-1-dp[i][j] && diff==2;z++){
          dp[i+z][j+z]=dp[i+z-1][j+z-1];
        }
      }
    System.out.println(Arrays.deepToString(dp));
    return answer;
  }
}
class Solution1 {
  public int countSubstrings(String s, String t) {
    int n=s.length();
    int m=t.length();
    int answer=0,diff=0;
    for(int i=0;i<=n;i++)
      for(int j=0;j<=m;j++){
        diff=0;
        for(int k=1;i+k-1<n && j+k-1<m && diff<2;k++){
          if(s.charAt(i+k-1)!=t.charAt(j+k-1)) diff++;
          if(diff==1) answer++;
        }
      }
    return answer;
  }
}

}