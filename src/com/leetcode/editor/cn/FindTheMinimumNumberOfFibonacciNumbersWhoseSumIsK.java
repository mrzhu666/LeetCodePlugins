package com.leetcode.editor.cn;


//////////////Given an integer k, return the minimum number of Fibonacci 
//numbers 
////////whose 
////////////sum 
//////////////is equal to k. The same Fibonacci number can be used multiple 
//times.
//// 
//////////////
////////////// The Fibonacci numbers are defined as: 
//////////////
////////////// 
////////////// F1 = 1 
////////////// F2 = 1 
////////////// Fn = Fn-1 + Fn-2 for n > 2. 
////////////// 
//////////////It is guaranteed that for the given constraints we can always 
//find 
//////such 
////////
//////////////Fibonacci numbers that sum up to k.
////////////// 
////////////// Example 1: 
//////////////
////////////// 
//////////////Input: k = 7
//////////////Output: 2 
//////////////Explanation: The Fibonacci numbers are: 1, 1, 2, 3, 5, 8, 13, ... 
//
//////////////For k = 7 we can use 2 + 5 = 7. 
//////////////
////////////// Example 2: 
//////////////
////////////// 
//////////////Input: k = 10
//////////////Output: 2 
//////////////Explanation: For k = 10 we can use 2 + 8 = 10.
////////////// 
//////////////
////////////// Example 3: 
//////////////
////////////// 
//////////////Input: k = 19
//////////////Output: 3 
//////////////Explanation: For k = 19 we can use 1 + 5 + 13 = 19.
////////////// 
//////////////
////////////// 
////////////// Constraints: 
//////////////
////////////// 
////////////// 1 <= k <= 10⁹ 
////////////// 
////////////// Related Topics 贪心 👍 98 👎 0
////////////
//////////
////////
//////
////
//


import java.util.*;
import java.lang.*;

public class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK {
    public static void main(String[] args) {
        Solution solution = new FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK().new Solution();
        System.out.println(solution.findMinFibonacciNumbers(10));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinFibonacciNumbers(int k) {
            int ans=0;
            int first=1,second=1;
            while(first<=k){
                int tmp=first+second;
                second=first;first=tmp;
            }
            while(k>0){
                if(first<=k){
                    k-=first;
                    ans++;
                }
                int tmp=first-second;
                first=second;second=tmp;
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


}

