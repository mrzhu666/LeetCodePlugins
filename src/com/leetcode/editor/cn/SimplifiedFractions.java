package com.leetcode.editor.cn;

//Given an integer n, return a list of all simplified fractions between 0 and 1 
//(exclusive) such that the denominator is less-than-or-equal-to n. You can 
//return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: ["1/2"]
//Explanation: "1/2" is the only unique fraction with a denominator less-than-
//or-equal-to 2.
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: ["1/2","1/3","2/3"]
// 
//
// Example 3: 
//
// 
//Input: n = 4
//Output: ["1/2","1/3","1/4","2/3","3/4"]
//Explanation: "2/4" is not a simplified fraction because it can be simplified 
//to "1/2".
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 100 
// 
// Related Topics 数学 字符串 数论 👍 79 👎 0


import java.util.*;
import java.lang.*;

public class SimplifiedFractions {
    public static void main(String[] args) {
        Solution solution = new SimplifiedFractions().new Solution();
        System.out.println(solution);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int gcd(int a, int b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }
        
        public List<String> simplifiedFractions(int n) {
            List<String> ans = new ArrayList<>();
            for (int b = 2; b <= n; b++)
                for (int a = 1; a < b; a++) {
                    if(gcd(a,b)==1)
                        ans.add(a+"/"+b);
                }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}

