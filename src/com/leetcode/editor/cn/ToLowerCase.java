//Given a string s, return the string after replacing every uppercase letter 
//with the same lowercase letter. 
//
// 
// Example 1: 
//
// 
//Input: s = "Hello"
//Output: "hello"
// 
//
// Example 2: 
//
// 
//Input: s = "here"
//Output: "here"
// 
//
// Example 3: 
//
// 
//Input: s = "LOVELY"
//Output: "lovely"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s consists of printable ASCII characters. 
// 
// Related Topics 字符串 👍 180 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class ToLowerCase{
  public static void main(String[] args) {
    Solution solution = new ToLowerCase().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String toLowerCase(String s) {
      return s.toLowerCase();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}