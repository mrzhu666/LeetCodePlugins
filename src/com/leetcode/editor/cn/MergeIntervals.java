//Given an array of intervals where intervals[i] = [starti, endi], merge all 
//overlapping intervals, and return an array of the non-overlapping intervals that 
//cover all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics 数组 排序 👍 1248 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class MergeIntervals{
  public static void main(String[] args) {
    Solution solution = new MergeIntervals().new Solution();
    System.out.print(Arrays.deepToString(solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
      int n=intervals.length;
      if(n==1)
        return intervals;
      Arrays.sort(intervals,((o1, o2) -> o1[0]-o2[0]));
      List<int[]> ans=new ArrayList<>();
      for(int i=0;i<n;i++){
        int right=intervals[i][1];
        int index=i+1;
        for(;index<n;index++){
          if(right<intervals[index][0]){
            index--;
            break;
          }
          right=Math.max(right,intervals[index][1]);
        }

        if(index==n) index--;
        if(i!=index) {
          ans.add(new int[]{intervals[i][0], right});
          i=index;
        }
        else
          ans.add(intervals[i]);
      }
      return ans.toArray(new int[0][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}