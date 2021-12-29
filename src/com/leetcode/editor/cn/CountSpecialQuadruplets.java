//Given a 0-indexed integer array nums, return the number of distinct 
//quadruplets (a, b, c, d) such that: 
//
// 
// nums[a] + nums[b] + nums[c] == nums[d], and 
// a < b < c < d 
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,6]
//Output: 1
//Explanation: The only quadruplet that satisfies the requirement is (0, 1, 2, 3
//) because 1 + 2 + 3 == 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,3,6,4,5]
//Output: 0
//Explanation: There are no such quadruplets in [3,3,6,4,5].
// 
//
// Example 3: 
//
// 
//Input: nums = [1,1,1,3,5]
//Output: 4
//Explanation: The 4 quadruplets that satisfy the requirement are:
//- (0, 1, 2, 3): 1 + 1 + 1 == 3
//- (0, 1, 3, 4): 1 + 1 + 3 == 5
//- (0, 2, 3, 4): 1 + 1 + 3 == 5
//- (1, 2, 3, 4): 1 + 1 + 3 == 5
// 
//
// 
// Constraints: 
//
// 
// 4 <= nums.length <= 50 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 枚举 👍 54 👎 0

package com.leetcode.editor.cn;


import java.util.*;
import java.lang.*;

public class CountSpecialQuadruplets{
  public static void main(String[] args) {
    Solution solution = new CountSpecialQuadruplets().new Solution();
    System.out.print(solution.countQuadruplets(new int[]{13,51,20,84,12,85,26,15,51,63,12,24,49,24,6,57,34,69,74,17}));
  }

//leetcode submit region begin(Prohibit modification and deletion)

class Solution{
  public int countQuadruplets(int[] nums) {
    int n = nums.length;
    int ans = 0;
    Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
    for (int c = n - 2; c >= 2; --c) {
      cnt.put(nums[c + 1], cnt.getOrDefault(nums[c + 1], 0) + 1);
      for (int a = 0; a < c; ++a) {
        for (int b = a + 1; b < c; ++b) {
          if(cnt.getOrDefault(nums[a] + nums[b] + nums[c], 0)!=0)
            System.out.format("%d %d %d %d\n",nums[a],nums[b],nums[c],nums[a]+nums[b]+nums[c]);
          ans += cnt.getOrDefault(nums[a] + nums[b] + nums[c], 0);
        }
      }
    }
    return ans;
  }
}

//leetcode submit region end(Prohibit modification and deletion)

  // 未解决
  // 关于重复数字计数需要多加考虑
  class Solution1 {
    public int countQuadruplets(int[] nums) {
      List<Integer> sort=new ArrayList<>();
      int answer=0;
      int n=nums.length;
      sort.add(nums[0]);
      sort.add(nums[1]);
      sort.add(nums[2]);
      Collections.sort(sort);
      for(int d=3;d<n;d++){
        for(int a=0;a<d-2;a++){
          if(sort.get(a)>=nums[d]) break;
          int b=a+1,c=d-1;
          while(b<c){
            while(b<c && sort.get(b)+sort.get(c)>nums[d]-sort.get(a)) c--;
            while(b<c && sort.get(b)+sort.get(c)<nums[d]-sort.get(a)) b++;
            if(b<c && sort.get(b)+sort.get(c)==nums[d]-sort.get(a)){
              System.out.format("%d %d %d %d\n",sort.get(a),sort.get(b),sort.get(c),nums[d]);
              answer++;
              if(sort.get(b+1).equals(sort.get(b))) b++;
              else if(sort.get(c-1).equals(sort.get(c))) c--;
              else b++;
            }
          }
        }

        sort.add(nums[d]);
        Collections.sort(sort);
        System.out.println(sort);
      }
      return answer;
    }
  }


}