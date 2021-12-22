//Given two strings a and b, return the minimum number of times you should 
//repeat string a so that string b is a substring of it. If it is impossible for b to 
//be a substring of a after repeating it, return -1. 
//
// Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and 
//repeated 2 times is "abcabc". 
//
// 
// Example 1: 
//
// 
//Input: a = "abcd", b = "cdabcdab"
//Output: 3
//Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b 
//is a substring of it.
// 
//
// Example 2: 
//
// 
//Input: a = "a", b = "aa"
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: a = "a", b = "a"
//Output: 1
// 
//
// Example 4: 
//
// 
//Input: a = "abc", b = "wxyz"
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= a.length <= 10⁴ 
// 1 <= b.length <= 10⁴ 
// a and b consist of lower-case English letters. 
// 
// Related Topics 字符串 字符串匹配 👍 181 👎 0

package com.leetcode.editor.cn;

import java.lang.*;

public class RepeatedStringMatch {
  public static void main(String[] args) {
    Solution solution = new RepeatedStringMatch().new Solution();
    System.out.print(solution);
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int repeatedStringMatch(String a, String b) {
      if (b == null) return 0;
      // 判断字母是否相同
      char[] A = a.toCharArray();
      char[] B = b.toCharArray();
      boolean[] alpha = new boolean[26];
      for (char c : A) {
        alpha[c - 'a'] = true;
      }
      for (char c : B) {
        if (!alpha[c - 'a']) return -1;
      }

      int first = b.indexOf(a);
      int na = a.length();
      int nb = b.length();
      if (first == -1) {
        if (a.contains(b)) return 1;
        StringBuilder dp = new StringBuilder();
        dp.append(a);
        dp.append(a);
        if (dp.indexOf(b) != -1) return 2;
        return -1;
      }

      for (int i = first - 1; i > -1; i--)
        if (B[i] != A[i - first + na])
          return -1;
      for (int i = first + na; i < nb; i++)
        if (B[i] != A[(i - first) % na])
          return -1;
      int answer = first == 0 ? 0 : 1;
      answer += (int) Math.ceil(((float) (nb - first)) / na);
      return answer;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}