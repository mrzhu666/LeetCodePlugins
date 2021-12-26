//A binary tree is named Even-Odd if it meets the following conditions: 
//
// 
// The root of the binary tree is at level index 0, its children are at level 
//index 1, their children are at level index 2, etc. 
// For every even-indexed level, all nodes at the level have odd integer values 
//in strictly increasing order (from left to right). 
// For every odd-indexed level, all nodes at the level have even integer values 
//in strictly decreasing order (from left to right). 
// 
//
// Given the root of a binary tree, return true if the binary tree is Even-Odd, 
//otherwise return false. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
//Output: true
//Explanation: The node values on each level are:
//Level 0: [1]
//Level 1: [10,4]
//Level 2: [3,7,9]
//Level 3: [12,8,6,2]
//Since levels 0 and 2 are all odd and increasing and levels 1 and 3 are all 
//even and decreasing, the tree is Even-Odd.
// 
//
// Example 2: 
//
// 
//Input: root = [5,4,2,3,3,7]
//Output: false
//Explanation: The node values on each level are:
//Level 0: [5]
//Level 1: [4,2]
//Level 2: [3,3,7]
//Node values in level 2 must be in strictly increasing order, so the tree is 
//not Even-Odd.
// 
//
// Example 3: 
//
// 
//Input: root = [5,9,1,3,5,7]
//Output: false
//Explanation: Node values in the level 1 should be even integers.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁵]. 
// 1 <= Node.val <= 10⁶ 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 31 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class EvenOddTree{
  public static void main(String[] args) {
    Solution solution = new EvenOddTree().new Solution();
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
    public boolean isEvenOddTree(TreeNode root) {
    Queue<TreeNode> q=new ArrayDeque<>();
    q.offer(root);
    int level=0;
    int size;
    TreeNode left;
    while(!q.isEmpty()){
      size=q.size();
      left=q.poll();
      if(level%2==0 && left.val%2!=1) return false;
      if(level%2==1 && left.val%2!=0) return false;

      if(left.left!=null) q.offer(left.left);
      if(left.right!=null) q.offer(left.right);
      for(int i=1;i<size;i++){
        if(level%2==0 && left.val>=q.peek().val) return false;
        if(level%2==1 && left.val<=q.peek().val) return false;
        left=q.poll();
        if(level%2==0 && left.val%2!=1) return false;
        if(level%2==1 && left.val%2!=0) return false;
        if(left.left!=null) q.offer(left.left);
        if(left.right!=null) q.offer(left.right);
      }
      level++;
    }
      return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}