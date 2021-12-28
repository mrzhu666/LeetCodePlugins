//Given an integer numRows, return the first numRows of Pascal's triangle. 
//
// In Pascal's triangle, each number is the sum of the two numbers directly 
//above it as shown: 
//
// 
// Example 1: 
// Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Example 2: 
// Input: numRows = 1
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 👍 652 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class PascalsTriangle{
  public static void main(String[] args) {
    Solution solution = new PascalsTriangle().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> tri=new ArrayList<>();
      tri.add(Collections.singletonList(1));
      List<Integer> cur,last = null;
      for(int i=2;i<=numRows;i++){
        cur=new ArrayList<>();
        cur.add(1);

        for(int j=0;j<i-2;j++)
          cur.add(last.get(j)+last.get(j+1));

        cur.add(1);
        tri.add(cur);
        last=cur;
      }
      return tri;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}