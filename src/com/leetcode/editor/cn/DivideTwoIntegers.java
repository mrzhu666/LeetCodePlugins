package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
        System.out.println(solution.divide(-2147483648,2));
    }

    class Solution {
        public int divide(int dividend, int divisor) {
            if (divisor == -1 && dividend == Integer.MIN_VALUE)
                return Integer.MAX_VALUE;

            if (dividend < 0 && divisor < 0) {
                return divide(-(long) dividend, -(long) divisor);
            } else if (dividend < 0 || divisor < 0) {
                return -divide(Math.abs((long) dividend), Math.abs((long) divisor));
            } else {
                return divide((long) dividend, (long) divisor);
            }
        }

        private int divide(long dividend, long divisor) {
            if (dividend < divisor) return 0;
            int count = 1;
            long tb = divisor;
            while ((tb << 1) <= dividend) {
                tb <<= 1;
                count <<= 1;
            }
            return count + divide(dividend - tb, divisor);
        }
    }

}
