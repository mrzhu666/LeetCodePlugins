//The power of the string is the maximum length of a non-empty substring that 
//contains only one unique character. 
//
// Given a string s, return the power of s. 
//
// 
// Example 1: 
//
// 
//Input: s = "leetcode"
//Output: 2
//Explanation: The substring "ee" is of length 2 with the character 'e' only.
// 
//
// Example 2: 
//
// 
//Input: s = "abbcccddddeeeeedcba"
//Output: 5
//Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
//
// 
//
// Example 3: 
//
// 
//Input: s = "triplepillooooow"
//Output: 5
// 
//
// Example 4: 
//
// 
//Input: s = "hooraaaaaaaaaaay"
//Output: 11
// 
//
// Example 5: 
//
// 
//Input: s = "tourist"
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 500 
// s consists of only lowercase English letters. 
// 
// Related Topics 字符串 👍 37 👎 0


package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class ConsecutiveCharacters{
  public static void main(String[] args) {
    Solution solution = new ConsecutiveCharacters().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxPower(String s) {
      int answer=1,record=1;
      int n=s.length();
      char[] sChar=s.toCharArray();
      for(int i=1;i<n;i++){
        if(sChar[i]==sChar[i-1]){
          record+=1;
        }
        else{
          record=1;
        }
        answer=Math.max(answer,record);
      }
      return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}