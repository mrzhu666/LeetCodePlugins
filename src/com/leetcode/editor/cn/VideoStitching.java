//You are given a series of video clips from a sporting event that lasted time 
//seconds. These video clips can be overlapping with each other and have varying 
//lengths. 
//
// Each video clip is described by an array clips where clips[i] = [starti, 
//endi] indicates that the ith clip started at starti and ended at endi. 
//
// We can cut these clips into segments freely. 
//
// 
// For example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].
// 
// 
//
// Return the minimum number of clips needed so that we can cut the clips into 
//segments that cover the entire sporting event [0, time]. If the task is 
//impossible, return -1. 
//
// 
// Example 1: 
//
// 
//Input: clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], time = 10
//Output: 3
//Explanation: 
//We take the clips [0,2], [8,10], [1,9]; a total of 3 clips.
//Then, we can reconstruct the sporting event as follows:
//We cut [1,9] into segments [1,2] + [2,8] + [8,9].
//Now we have segments [0,2] + [2,8] + [8,10] which cover the sporting event [0,
// 10].
// 
//
// Example 2: 
//
// 
//Input: clips = [[0,1],[1,2]], time = 5
//Output: -1
//Explanation: We can't cover [0,5] with only [0,1] and [1,2].
// 
//
// Example 3: 
//
// 
//Input: clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2
//,5],[2,6],[3,4],[4,5],[5,7],[6,9]], time = 9
//Output: 3
//Explanation: We can take clips [0,4], [4,7], and [6,9].
// 
//
// Example 4: 
//
// 
//Input: clips = [[0,4],[2,8]], time = 5
//Output: 2
//Explanation: Notice you can have extra video after the event ends.
// 
//
// 
// Constraints: 
//
// 
// 1 <= clips.length <= 100 
// 0 <= starti <= endi <= 100 
// 1 <= time <= 100 
// 
// Related Topics 贪心 数组 动态规划 👍 255 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class VideoStitching{
  public static void main(String[] args) {
    Solution solution = new VideoStitching().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int videoStitching(int[][] clips, int time) {
    Arrays.sort(clips,(int[] x,int[] y)->{
      if(x[0]!=y[0]) return x[0]-y[0];
      else return y[1]-x[1];
    });
    int answer=0;
    int i=0;
    int curEnd=0;
    int nextEnd=0;
    int n=clips.length;
    while(i<n && clips[i][0]<=curEnd){
      while(i<n && clips[i][0]<=curEnd){
        nextEnd=Math.max(nextEnd,clips[i][1]);
        i++;
      }
      answer++;
      curEnd=nextEnd;
      if(curEnd>=time)return answer;
    }
    return -1;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
class Solution1 {
  public int videoStitching(int[][] clips, int time) {
    Arrays.sort(clips, new Comparator<int[]>() {
      /** 第一列升序，相等时长度降序 **/
      @Override
      public int compare(int[] o1, int[] o2) {
        if(o1[0]!=o2[0]) return o1[0]-o2[0];
        else return o2[1]-o1[1];
      }
    });
    if(clips[0][0]!=0) return -1;
    int e=clips[0][1];
    int index=0;
    int answer=1;
    if(e>=time) return 1;
    for(int i=1;i<clips.length;i++){
      if(clips[i-1][0]==clips[i][0]) continue;
      if(clips[i][1]<=e) continue;

      if(e<clips[i][0]){
        e=clips[index][1];
        answer++;
      }
      /** 在start[i]大于e(end)的情况下 选出最大的end[i] **/
      if(clips[i][0]<=e && clips[index][1]<clips[i][1]){
        index=i;
        if(clips[index][1]>=time) return answer+1;
      }
    }
    return -1;
  }
}

}