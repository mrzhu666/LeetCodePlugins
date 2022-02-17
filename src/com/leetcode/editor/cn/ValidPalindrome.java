package com.leetcode.editor.cn;

//A phrase is a palindrome if, after converting all uppercase letters into 
//lowercase letters and removing all non-alphanumeric characters, it reads the same 
//forward and backward. Alphanumeric characters include letters and numbers. 
//
// Given a string s, return true if it is a palindrome, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
// 
//
// Example 2: 
//
// 
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric 
//characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s consists only of printable ASCII characters. 
// 
// Related Topics 双指针 字符串 👍 471 👎 0


import java.util.*;
import java.lang.*;

public class ValidPalindrome {
    public static void main (String[] args){
        Solution solution = new ValidPalindrome().new Solution();
        System.out.println(solution);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder string=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(Character.isLetter(ch))
                string.append(Character.toLowerCase(ch));
            else if(Character.isDigit(ch))
                string.append(ch);
        }
        int n=string.length();
        
        for(int i=0;i<=n-1-i;i++)
            if(string.charAt(i)!=string.charAt(n-1-i))
                return false;
        
        
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}

