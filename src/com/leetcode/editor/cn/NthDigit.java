//Given an integer n, return the nᵗʰ digit of the infinite integer sequence [1, 
//2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...]. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: n = 11
//Output: 0
//Explanation: The 11ᵗʰ digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
// ... is a 0, which is part of the number 10.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics 数学 二分查找 👍 251 👎 0


package com.leetcode.editor.cn;


import java.util.*;
import java.lang.*;

public class NthDigit {
  public static void main(String[] args) {
    Solution solution = new NthDigit().new Solution();
    System.out.print(solution.findNthDigit(2147483647));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    long[] presum = new long[]{0, 9, 189, 2889, 38889, 488889, 5888889, 68888889, 788888889, 8888888889L};

    /**
     * 计算前1到num的序列长度
     *
     * @param num 结尾数字
     * @return 序列长度
     */
    public long count(long num) {
      int n = String.valueOf(num).length();
      long sum = (long) ((num - Math.pow(10, n - 1) + 1) * n);
      return presum[n - 1] + sum;
    }

    public int findNthDigit(int n) {
      if (n == 1) return 1;
      long mid, left = 1, right = (int) Math.pow(10, 11) - 1;
      while (right - left > 1) {
        mid = (left + right) / 2;
        if (count(mid) < n)
          left = mid;
        else
          right = mid;
      }
      long sum = count(right);
      long lenght = String.valueOf(right).length();
      return String.valueOf(right).charAt((int) (lenght - (sum - n) - 1)) - '0';
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}