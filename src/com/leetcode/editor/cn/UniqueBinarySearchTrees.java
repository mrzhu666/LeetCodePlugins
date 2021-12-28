//Given an integer n, return the number of structurally unique BST's (binary 
//search trees) which has exactly n nodes of unique values from 1 to n. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 1453 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class UniqueBinarySearchTrees{
  public static void main(String[] args) {
    Solution solution = new UniqueBinarySearchTrees().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
      int[] G=new int[n+1];
      G[0]=1;
      G[1]=1;
      for(int i=2;i<n+1;i++)
        for(int j=0;j<=i-1;j++)
          G[i]+=G[j]*G[i-j-1];
      return G[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}