package com.leetcode.editor.cn;

//Given two strings s and t of lengths m and n respectively, return the minimum 
//window substring of s such that every character in t (including duplicates) is 
//included in the window. If there is no such substring, return the empty string 
//"". 
//
// The testcases will be generated such that the answer is unique. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' 
//from string t.
// 
//
// Example 2: 
//
// 
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
//Follow up: Could you find an algorithm that runs in O(m + n) time? Related 
//Topics 哈希表 字符串 滑动窗口 👍 1641 👎 0

import java.util.*;
import java.lang.*;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("a","a"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int[] cnt1 = new int[128];
            int[] cnt2 = new int[128];
            int diff = 0, n = s.length(), m = t.length();
            if (m > n || m == 0) return "";
            int index = 0, length = Integer.MAX_VALUE;
            
            for (int i = 0; i < m; i++) {
                char tmp = t.charAt(i);
                if (cnt2[tmp] == 0) diff++;
                cnt2[tmp]++;
            }
    
            int left = 0, right = -2;
            for(int i=0;i<n;i++){
                char tmp = s.charAt(i);
                if(cnt2[tmp]!=0){
                    left=i;right=i-1;
                    break;
                }
            }
            if(right==-2) return "";
            char tmp;
            while (right!=n-1 || cnt2[s.charAt(right)]!=0) {
                while (diff != 0 && right != n - 1) {
                    right++;
                    tmp = s.charAt(right);
                    cnt1[tmp]++;
                    if (cnt1[tmp] == cnt2[tmp])
                        diff--;
                }
                tmp = s.charAt(left);
                while (cnt1[tmp] != cnt2[tmp]) {
                    cnt1[tmp]--;
                    left++;
                    if(left>right) break;
                    tmp = s.charAt(left);
                }
                if (diff == 0 && length > right - left + 1) {
                    length = right - left + 1;
                    index = left;
                }
                while (diff == 0 && left <= right) {
                    tmp = s.charAt(left);
                    cnt1[tmp]--;
                    left++;
                    if (cnt2[tmp]!=0 && cnt1[tmp] + 1 == cnt2[tmp])
                        diff++;
                }
                if(left==n) break;
                if(left>right) continue;
                tmp = s.charAt(left);
                while (cnt1[tmp] != cnt2[tmp]) {
                    cnt1[tmp]--;
                    left++;
                    if(left>right) break;
                    tmp = s.charAt(left);
                }
                if(right==n-1)
                    break;
            }
            
            return length==Integer.MAX_VALUE?"":s.substring(index, index + length);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}

