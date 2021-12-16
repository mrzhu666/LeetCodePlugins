//You are given an integer array nums. You want to maximize the number of 
//points you get by performing the following operation any number of times: 
//
// 
// Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must 
//delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
// 
// 
//
// Return the maximum number of points you can earn by applying the above 
//operation some number of times. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,4,2]
//Output: 6
//Explanation: You can perform the following operations:
//- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
//- Delete 2 to earn 2 points. nums = [].
//You earn a total of 6 points.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,3,3,3,4]
//Output: 9
//Explanation: You can perform the following operations:
//- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
//
//- Delete a 3 again to earn 3 points. nums = [3].
//- Delete a 3 once more to earn 3 points. nums = [].
//You earn a total of 9 points. 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 哈希表 动态规划 👍 495 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

public class DeleteAndEarn{
  public static void main(String[] args) {
    Solution solution = new DeleteAndEarn().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*最后一个数字计数+1*/
  public void increment(List<Integer> num,int add){
    int n=num.size();
    num.set(n-1,num.get(n-1)+add);
  }
  public int deleteAndEarn(int[] nums) {
    int n=nums.length;
    if(n>10000)n=10000;
    Arrays.sort(nums);
    int index=0;
    int[] dp=new int[n];
    int[] bp=new int[n];
    dp[0]=nums[0];
    for(int i=1;i<n;i++){
      if(nums[i]==nums[i-1])
        dp[index]+=nums[i];
      else if(nums[i]==nums[i-1]+1){
        index++;
        dp[index]=bp[index-1]+nums[i];
        bp[index]=Math.max(dp[index-1],bp[index-1]);
      }
      else{
        index++;
        dp[index]=Math.max(dp[index-1],bp[index-1])+nums[i];
        bp[index]=Math.max(dp[index-1],bp[index-1]);
      }
    }
    return Math.max(dp[index],bp[index]);
  }
}
//leetcode submit region end(Prohibit modification and deletion)

class Solution1 {
    /*最后一个数字计数+1*/
  public void increment(List<Integer> num){
    int n=num.size();
    num.set(n-1,num.get(n-1)+1);
  }
  public int deleteAndEarn(int[] nums) {
    int n=nums.length;
    Arrays.sort(nums);
    List<Integer> digit=new ArrayList<Integer>();
    List<Integer> num=new ArrayList<Integer>();
    digit.add(nums[0]);
    num.add(1);
    for(int i=1;i<n;i++){
      if(nums[i]==nums[i-1]){
        increment(num);
      }
      else{
        digit.add(nums[i]);
        num.add(1);
      }
    }
    n=digit.size();
    if(n==1) return digit.get(0)*num.get(0);
    if(n==2) {
      if(digit.get(0)==digit.get(1)-1) return Math.max(digit.get(0)*num.get(0),digit.get(1)*num.get(1));
      else return digit.get(0)*num.get(0)+digit.get(1)*num.get(1);
    }

    int[] dp=new int[n];
    dp[0]=digit.get(0)*num.get(0);
    if(digit.get(0)==digit.get(1)-1)
      dp[1]=Math.max(digit.get(1)*num.get(1),dp[0]);
    else
      dp[1]=digit.get(1)*num.get(1)+dp[0];

    for(int i=2;i<n;i++){
      if(digit.get(i-1)==digit.get(i)-1)
        dp[i]=Math.max(digit.get(i)*num.get(i)+dp[i-2],dp[i-1]);
      else
        dp[i]=digit.get(i)*num.get(i)+dp[i-1];
    }

    return Math.max(dp[n-1],dp[n-2]);
  }
}


}