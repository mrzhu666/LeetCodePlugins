package com.leetcode.editor.cn;

//Given two strings s1 and s2, return true if s2 contains a permutation of s1, 
//or false otherwise. 
//
// In other words, return true if one of s1's permutations is the substring of 
//s2. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "ab", s2 = "eidbaooo"
//Output: true
//Explanation: s2 contains one permutation of s1 ("ba").
// 
//
// Example 2: 
//
// 
//Input: s1 = "ab", s2 = "eidboaoo"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 and s2 consist of lowercase English letters. 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 565 👎 0


import java.util.*;
import java.lang.*;


public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        System.out.println(solution);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean check(int[] s1Letter, int[] s2Letter) {
            for (int i = 0; i < 26; i++)
                if (s1Letter[i] != s2Letter[i])
                    return false;
            return true;
        }
        
        public boolean checkInclusion(String s1, String s2) {
            int[] s1Letter = new int[26];
            int[] s2Letter = new int[26];
            int k = s1.length();
            for (int i = 0; i < s1.length(); i++)
                s1Letter[s1.charAt(i) - 'a']++;
            for (int i = 0; i < s2.length(); i++) {
                s2Letter[s2.charAt(i) - 'a']++;
                if (i >= k)
                    s2Letter[s2.charAt(i - k) - 'a']--;
                if (i >= k - 1) {
                    if(check(s1Letter,s2Letter))
                        return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}

