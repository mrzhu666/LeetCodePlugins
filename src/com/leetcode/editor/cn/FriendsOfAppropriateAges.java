//There are n persons on a social media website. You are given an integer array 
//ages where ages[i] is the age of the iᵗʰ person. 
//
// A Person x will not send a friend request to a person y (x != y) if any of 
//the following conditions is true: 
//
// 
// age[y] <= 0.5 * age[x] + 7 
// age[y] > age[x] 
// age[y] > 100 && age[x] < 100 
// 
//
// Otherwise, x will send a friend request to y. 
//
// Note that if x sends a request to y, y will not necessarily send a request 
//to x. Also, a person will not send a friend request to themself. 
//
// Return the total number of friend requests made. 
//
// 
// Example 1: 
//
// 
//Input: ages = [16,16]
//Output: 2
//Explanation: 2 people friend request each other.
// 
//
// Example 2: 
//
// 
//Input: ages = [16,17,18]
//Output: 2
//Explanation: Friend requests are made 17 -> 16, 18 -> 17.
// 
//
// Example 3: 
//
// 
//Input: ages = [20,30,100,110,120]
//Output: 3
//Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
// 
//
// 
// Constraints: 
//
// 
// n == ages.length 
// 1 <= n <= 2 * 10⁴ 
// 1 <= ages[i] <= 120 
// 
// Related Topics 数组 双指针 二分查找 排序 👍 95 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class FriendsOfAppropriateAges{
  public static void main(String[] args) {
    Solution solution = new FriendsOfAppropriateAges().new Solution();
    System.out.print(solution.numFriendRequests(new int[]{8,85,24,85,69}));
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int numFriendRequests(int[] ages) {
      int answer=0;
      int[] count=new int[121];
      int[] pre=new int[121];
      for (int age : ages) count[age]++;
      for(int i=1;i<121;i++)
        pre[i]=count[i]+pre[i-1];
      for(int i=120;i>14;i--){
        if(count[i]==0) continue;
        if(count[i]>1) answer+=count[i]*(count[i]-1);
        int y=(int)(0.5*i+8);
//        System.out.println(y+" "+i);
        answer+=(pre[i-1]-pre[y-1])*count[i];
      }
      return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}