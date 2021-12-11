//Given a string s, find the length of the longest substring without repeating 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 6507 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class LongestSubstringWithoutRepeatingCharacters{
  public static void main(String[] args) {
    Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    System.out.print(solution.lengthOfLongestSubstring("pwwkew"));
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int lengthOfLongestSubstring(String s) {
    boolean[] chSet=new boolean[127];
    int n=s.length();
    if(n==0) return 0;
    int first=0,second=1;
    int answer=1;
    chSet[s.charAt(0)]=true;
    while(second<n){
      char ch=s.charAt(second);
      if(first==second){
        chSet[ch]=true;
        second++;
      }
      else if (chSet[ch]){
        answer=Math.max(answer,second-first);
        chSet[s.charAt(first)]=false;
        first++;
      }
      else{
        chSet[ch]=true;
        second++;
        answer=Math.max(answer,second-first);
      }

    }
    return answer;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

}