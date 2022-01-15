//You are given two integer arrays nums1 and nums2 sorted in ascending order 
//and an integer k. 
//
// Define a pair (u, v) which consists of one element from the first array and 
//one element from the second array. 
//
// Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums. 
//
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//Output: [[1,2],[1,4],[1,6]]
//Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,
//6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//Output: [[1,1],[1,1]]
//Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,
//2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// Example 3: 
//
// 
//Input: nums1 = [1,2], nums2 = [3], k = 3
//Output: [[1,3],[2,3]]
//Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁵ 
// -10⁹ <= nums1[i], nums2[i] <= 10⁹ 
// nums1 and nums2 both are sorted in ascending order. 
// 1 <= k <= 1000 
// 
// Related Topics 数组 堆（优先队列） 👍 279 👎 0

package com.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;

public class FindKPairsWithSmallestSums {
  public static void main(String[] args) {
    Solution solution = new FindKPairsWithSmallestSums().new Solution();
    System.out.print(solution);
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      List<List<Integer>> ans = new ArrayList<>();
      PriorityQueue<List<Integer>> queue = new PriorityQueue<>(((o1, o2) -> nums1[o1.get(0)] + nums2[o1.get(1)] - nums1[o2.get(0)] - nums2[o2.get(1)]));
      int n = nums1.length;
      int m = nums2.length;
      for (int i = 0; i < n; i++)
        queue.add(Arrays.asList(i,0));
      while (!queue.isEmpty() && k != 0) {
        List<Integer> tmp = queue.poll();
        ans.add(Arrays.asList(nums1[tmp.get(0)],nums2[tmp.get(1)]));
        if(tmp.get(1)<m-1)
          queue.add(Arrays.asList(tmp.get(0),tmp.get(1)+1));
        k--;
      }
      return ans;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}