//The Tribonacci sequence Tn is defined as follows: 
//
// T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0. 
//
// Given n, return the value of Tn. 
//
// 
// Example 1: 
//
// 
//Input: n = 4
//Output: 4
//Explanation:
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
// 
//
// Example 2: 
//
// 
//Input: n = 25
//Output: 1389537
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 37 
// The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 -
// 1. 
// Related Topics 记忆化搜索 数学 动态规划 👍 154 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class NThTribonacciNumber{
  public static void main(String[] args) {
    int[] f=new int[38];
    f[0]=0;
    f[1]=1;
    f[2]=1;
    for(int i=3;i<38;i++){
      f[i]=f[i-1]+f[i-2]+f[i-3];
    }
    System.out.println(Arrays.toString(f));
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int tribonacci(int n) {
      int[] f=new int[]{0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504, 927, 1705, 3136, 5768, 10609, 19513, 35890, 66012, 121415, 223317, 410744, 755476, 1389537, 2555757, 4700770, 8646064, 15902591, 29249425, 53798080, 98950096, 181997601, 334745777, 615693474, 1132436852, 2082876103};
      return f[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}