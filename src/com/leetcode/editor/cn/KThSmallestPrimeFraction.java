//You are given a sorted integer array arr containing 1 and prime numbers, 
//where all the integers of arr are unique. You are also given an integer k. 
//
// For every i and j where 0 <= i < j < arr.length, we consider the fraction 
//arr[i] / arr[j]. 
//
// Return the kᵗʰ smallest fraction considered. Return your answer as an array 
//of integers of size 2, where answer[0] == arr[i] and answer[1] == arr[j]. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,2,3,5], k = 3
//Output: [2,5]
//Explanation: The fractions to be considered in sorted order are:
//1/5, 1/3, 2/5, 1/2, 3/5, and 2/3.
//The third fraction is 2/5.
// 
//
// Example 2: 
//
// 
//Input: arr = [1,7], k = 1
//Output: [1,7]
// 
//
// 
// Constraints: 
//
// 
// 2 <= arr.length <= 1000 
// 1 <= arr[i] <= 3 * 10⁴ 
// arr[0] == 1 
// arr[i] is a prime number for i > 0. 
// All the numbers of arr are unique and sorted in strictly increasing order. 
// 1 <= k <= arr.length * (arr.length - 1) / 2 
// 
// Related Topics 数组 二分查找 堆（优先队列） 👍 202 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class KThSmallestPrimeFraction{
  public static void main(String[] args) {
    Solution solution = new KThSmallestPrimeFraction().new Solution();
    System.out.print(solution.kthSmallestPrimeFraction(new int[]{1,2,3,5},3));
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
      int n=arr.length;
      PriorityQueue<int[]> queue=new PriorityQueue<>((o1, o2) -> Double.compare(arr[o1[0]]*1.0/arr[o1[1]],arr[o2[0]]*1.0/arr[o2[1]]));

      for(int i=0;i<n-1;i++)
        queue.add(new int[]{i,n-1});
      while(k!=1){
        int[] tmp=queue.poll();
        if(tmp[0]+1!=tmp[1])
          queue.add(new int[]{tmp[0],tmp[1]-1});
        k--;
      }

      return new int[]{arr[queue.peek()[0]],arr[queue.peek()[1]]};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}