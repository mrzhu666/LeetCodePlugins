//Given n non-negative integers representing an elevation map where the width 
//of each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
//
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) 
//are being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 2946 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class TrappingRainWater{
  public static void main(String[] args) {
    Solution solution = new TrappingRainWater().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int trap(int[] height) {
    int answer=0;
    int n=height.length;
    int[] leftMax=new int[n];
    leftMax[0]=height[0];
    int[] rightMax=new int[n];
    rightMax[n-1]=height[n-1];
    for(int i=1;i<n;i++)
      leftMax[i]=Math.max(height[i],leftMax[i-1]);
    for(int i=n-2;i>=0;i--)
      rightMax[i]=Math.max(height[i],rightMax[i+1]);
    for(int i=0;i<n;i++)
      answer+=Math.min(leftMax[i],rightMax[i])-height[i];
    return answer;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

}