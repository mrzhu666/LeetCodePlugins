package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
        System.out.println(solution.subarraySum(new int[]{1,1,1},2));
    }

    class Solution {
        public int subarraySum(int[] nums, int k) {
            int ans = 0, n = nums.length, sum = 0;
            Map<Integer, Integer> hash = new HashMap<>();
            hash.put(0, 1);
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                ans+=hash.getOrDefault(sum-k,0);
                hash.merge(sum,1,Integer::sum);
            }

            return ans;
        }
    }

    class Solution1 {
        public int subarraySum(int[] nums, int k) {
            int ans = 0, n = nums.length, sum;
            for (int i = 0; i < n; i++) {
                sum = 0;
                for (int j = i; j >= 0; j--) {
                    sum += nums[j];
                    if (sum == k)
                        ans++;
                }
            }
            return ans;
        }
    }

}
