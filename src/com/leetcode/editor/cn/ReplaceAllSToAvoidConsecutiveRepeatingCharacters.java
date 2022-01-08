//Given a string s containing only lowercase English letters and the '?' 
//character, convert all the '?' characters into lowercase letters such that the final 
//string does not contain any consecutive repeating characters. You cannot modify 
//the non '?' characters. 
//
// It is guaranteed that there are no consecutive repeating characters in the 
//given string except for '?'. 
//
// Return the final string after all the conversions (possibly zero) have been 
//made. If there is more than one solution, return any of them. It can be shown 
//that an answer is always possible with the given constraints. 
//
// 
// Example 1: 
//
// 
//Input: s = "?zs"
//Output: "azs"
//Explanation: There are 25 solutions for this problem. From "azs" to "yzs", 
//all are valid. Only "z" is an invalid modification as the string will consist of 
//consecutive repeating characters in "zzs".
// 
//
// Example 2: 
//
// 
//Input: s = "ubv?w"
//Output: "ubvaw"
//Explanation: There are 24 solutions for this problem. Only "v" and "w" are 
//invalid modifications as the strings will consist of consecutive repeating 
//characters in "ubvvw" and "ubvww".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s consist of lowercase English letters and '?'. 
// 
// Related Topics 字符串 👍 60 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class ReplaceAllSToAvoidConsecutiveRepeatingCharacters{
  public static void main(String[] args) {
    Solution solution = new ReplaceAllSToAvoidConsecutiveRepeatingCharacters().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String modifyString(String s) {
      int n=s.length();
      StringBuilder ans=new StringBuilder();
      for(int i=0;i<n;i++){
        if(s.charAt(i)!='?')
          ans.append(s.charAt(i));
        else{
          for(char j='a';j<='z';j++){
            if((i==0 || (j!=s.charAt(i-1) && j!=ans.charAt(i-1))) && (i==n-1 || j!=s.charAt(i+1))){
              ans.append(j);
              break;
            }
          }
        }
      }
      return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}