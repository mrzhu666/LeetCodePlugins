package com.leetcode.editor.cn;

//You are given an integer array nums. The unique elements of an array are the 
//elements that appear exactly once in the array. 
//
// Return the sum of all the unique elements of nums. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,2]
//Output: 4
//Explanation: The unique elements are [1,3], and the sum is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,1,1,1,1]
//Output: 0
//Explanation: There are no unique elements, and the sum is 0.
// 
//
// Example 3: 
//
// 
//Input: nums = [1,2,3,4,5]
//Output: 15
//Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 哈希表 计数 👍 40 👎 0


import java.util.*;
import java.lang.*;

public class SumOfUniqueElements {
    public static void main (String[] args){
        Solution solution = new SumOfUniqueElements().new Solution();
        System.out.println(solution);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumOfUnique(int[] nums) {
        int[] hash=new int[101];
        for(int v:nums)
            hash[v]++;
        int ans=0;
        for(int i=1;i<101;i++)
            if(hash[i]==1)
                ans+=i;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}

