//Given an integer n, return all the structurally unique BST's (binary search 
//trees), which has exactly n nodes of unique values from 1 to n. Return the answer 
//in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]
//]
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 👍 1083 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class UniqueBinarySearchTreesIi{
  public static void main(String[] args) {
    Solution solution = new UniqueBinarySearchTreesIi().new Solution();
    System.out.print(solution);
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int[] vis;
    public List<TreeNode> generateTrees(int n) {

      return generateTrees(1,n);
    }
    public List<TreeNode> generateTrees(int start,int end){
      List<TreeNode> allTrees=new ArrayList<>();
      if(start>end){
        allTrees.add(null);  // 不能直接返回null
        return allTrees;  // 不能直接返回null
      }
      for(int i=start;i<=end;i++){
        List<TreeNode> left=generateTrees(start,i-1);
        List<TreeNode> right=generateTrees(i+1,end);
        for(TreeNode l:left)
          for(TreeNode r:right){
            TreeNode cur=new TreeNode(i,l,r);
            allTrees.add(cur);
          }
      }
      return allTrees;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}