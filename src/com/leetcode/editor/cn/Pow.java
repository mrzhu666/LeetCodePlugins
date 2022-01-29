package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class Pow {
    public static void main(String[] args) {
        Solution solution = new Pow().new Solution();
        System.out.println(solution);
    }

    class Solution {
        public double myPow(double x, int n) {
            double res = 1.0;
            long N = n;
            if (N < 0) {
                x = 1 / x;
                N = -N;
            }
            while (N > 0) {
                if ((N & 1) == 1) res *= x;
                x *= x;
                N >>= 1;
            }
            return res;
        }
    }

}
