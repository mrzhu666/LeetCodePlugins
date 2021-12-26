//Implement strStr(). 
//
// Return the index of the first occurrence of needle in haystack, or -1 if 
//needle is not part of haystack. 
//
// Clarification: 
//
// What should we return when needle is an empty string? This is a great 
//question to ask during an interview. 
//
// For the purpose of this problem, we will return 0 when needle is an empty 
//string. This is consistent to C's strstr() and Java's indexOf(). 
//
// 
// Example 1: 
// Input: haystack = "hello", needle = "ll"
//Output: 2
// Example 2: 
// Input: haystack = "aaaaa", needle = "bba"
//Output: -1
// Example 3: 
// Input: haystack = "", needle = ""
//Output: 0
// 
// 
// Constraints: 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 10⁴ 
// haystack and needle consist of only lower-case English characters. 
// 
// Related Topics 双指针 字符串 字符串匹配 👍 1173 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class ImplementStrstr{
  public static void main(String[] args) {
    Solution solution = new ImplementStrstr().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
      int n=haystack.length(),m=needle.length();
      if(m==0) return 0;
      if(n==0) return -1;
      int[] p=new int[m];
      for(int i=1,j=0;i<m;i++){
        while(j>0 && needle.charAt(i)!=needle.charAt(j))
          j=p[j-1];
        if(needle.charAt(i)==needle.charAt(j))
          j++;
        p[i]=j;
      }
      for(int i=0,j=0;i<n;i++){
        while(j>0 && haystack.charAt(i)!=needle.charAt(j))
          j=p[j-1];
        if(haystack.charAt(i)==needle.charAt(j))
          j++;
        if(j==m) return i-m+1;
      }
      return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class Solution1 {
    public int strStr(String haystack, String needle) {
      int mod=100000;
      int a=26;
      int n=haystack.length();
      int m=needle.length();
      if(m==0) return 0;
      if(n==0) return -1;
      int power=1;
      int patHash=0;
      for(int i=0;i<m;i++){
        power=power*a%mod;
        patHash=(patHash*a+needle.charAt(i))%mod;
      }

      int hash=0;
      for(int i=0;i<n;i++){
        hash=(hash*a+haystack.charAt(i))%mod;
        if(i<m-1) continue;
        if(i>=m){
          hash=hash-power*haystack.charAt(i-m)%mod;
          if(hash<0) hash+=mod;
        }
        if(hash==patHash) return i-m+1;
      }
      return -1;
    }
}

}