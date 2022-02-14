package com.leetcode.editor.cn;

//Given a binary array nums, return the maximum length of a contiguous subarray 
//with an equal number of 0 and 1. 
//
// 
// Example 1: 
//
// 
//Input: nums = [0,1]
//Output: 2
//Explanation: [0, 1] is the longest contiguous subarray with an equal number 
//of 0 and 1.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,0]
//Output: 2
//Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal 
//number of 0 and 1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] is either 0 or 1. 
// 
// Related Topics 数组 哈希表 前缀和 👍 519 👎 0


import java.util.*;
import java.lang.*;

public class ContiguousArray {
    public static void main (String[] args){
        Solution solution = new ContiguousArray().new Solution();
        System.out.println(solution);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {
        int ans=0,n=nums.length;
        int pre=0;
        HashMap<Integer,Integer> odd=new HashMap<>();
        HashMap<Integer,Integer> even=new HashMap<>();
        even.put(0,0);
        HashMap<Integer,Integer> target;
        for(int i=1;i<=n;i++){
            pre+=nums[i-1];
            int key=2*pre-i;
            if(i%2==1)
                target=odd;
            else
                target=even;
            Integer j=target.get(key);
            if(j!=null)
                ans=Math.max(ans,i-j);
            else
                target.put(key,i);
            
        }
        
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}

