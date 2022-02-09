package com.leetcode.editor.cn;

//A string s is called happy if it satisfies the following conditions: 
//
// 
// s only contains the letters 'a', 'b', and 'c'. 
// s does not contain any of "aaa", "bbb", or "ccc" as a substring. 
// s contains at most a occurrences of the letter 'a'. 
// s contains at most b occurrences of the letter 'b'. 
// s contains at most c occurrences of the letter 'c'. 
// 
//
// Given three integers a, b, and c, return the longest possible happy string. 
//If there are multiple longest happy strings, return any of them. If there is no 
//such string, return the empty string "". 
//
// A substring is a contiguous sequence of characters within a string. 
//
// 
// Example 1: 
//
// 
//Input: a = 1, b = 1, c = 7
//Output: "ccaccbcc"
//Explanation: "ccbccacc" would also be a correct answer.
// 
//
// Example 2: 
//
// 
//Input: a = 7, b = 1, c = 0
//Output: "aabaa"
//Explanation: It is the only correct answer in this case.
// 
//
// 
// Constraints: 
//
// 
// 0 <= a, b, c <= 100 
// a + b + c > 0 
// 
// Related Topics 贪心 字符串 堆（优先队列） 👍 107 👎 0


import java.util.*;
import java.lang.*;

public class LongestHappyString {
    public static void main(String[] args) {
        Solution solution = new LongestHappyString().new Solution();
        System.out.println(solution);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestDiverseString(int a, int b, int c) {
            StringBuilder ans = new StringBuilder();
            
            PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });
            if (a != 0)
                q.add(new int[]{'a', a});
            if (b != 0)
                q.add(new int[]{'b', b});
            if (c != 0)
                q.add(new int[]{'c', c});
            
            while (!q.isEmpty()) {
                int[] first = q.poll();
                int[] second = q.poll();
                int length=ans.length();
                if(length==0 || ans.charAt(length-1)!=first[0]){
                    ans.append((char)first[0]);
                    first[1]--;
                    if(first[1]!=0){
                        ans.append((char)first[0]);
                        first[1]--;
                    }
                    if(second==null) break;
                    ans.append((char)second[0]);
                    second[1]--;
                    if(first[1]!=0) q.add(first);
                    if(second[1]!=0) q.add(second);
                }else if(ans.charAt(length-1)==first[0]){
                    ans.append((char)first[0]);
                    first[1]--;
                    if(second==null) break;
                    ans.append((char)second[0]);
                    second[1]--;
                    if(first[1]!=0) q.add(first);
                    if(second[1]!=0) q.add(second);
                }
                
            }
            
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}

