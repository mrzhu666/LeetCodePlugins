//You are given two integer arrays persons and times. In an election, the iᵗʰ 
//vote was cast for persons[i] at time times[i]. 
//
// For each query at a time t, find the person that was leading the election at 
//time t. Votes cast at time t will count towards our query. In the case of a tie,
// the most recent vote (among tied candidates) wins. 
//
// Implement the TopVotedCandidate class: 
//
// 
// TopVotedCandidate(int[] persons, int[] times) Initializes the object with 
//the persons and times arrays. 
// int q(int t) Returns the number of the person that was leading the election 
//at time t according to the mentioned rules. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["TopVotedCandidate", "q", "q", "q", "q", "q", "q"]
//[[[0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]], [3], [12], [25], [15], [
//24], [8]]
//Output
//[null, 0, 1, 1, 0, 0, 1]
//
//Explanation
//TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1,
// 0], [0, 5, 10, 15, 20, 25, 30]);
//topVotedCandidate.q(3); // return 0, At time 3, the votes are [0], and 0 is 
//leading.
//topVotedCandidate.q(12); // return 1, At time 12, the votes are [0,1,1], and 1
// is leading.
//topVotedCandidate.q(25); // return 1, At time 25, the votes are [0,1,1,0,0,1],
// and 1 is leading (as ties go to the most recent vote.)
//topVotedCandidate.q(15); // return 0
//topVotedCandidate.q(24); // return 0
//topVotedCandidate.q(8); // return 1
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= persons.length <= 5000 
// times.length == persons.length 
// 0 <= persons[i] < persons.length 
// 0 <= times[i] <= 10⁹ 
// times is sorted in a strictly increasing order. 
// times[0] <= t <= 10⁹ 
// At most 10⁴ calls will be made to q. 
// 
// Related Topics 设计 数组 哈希表 二分查找 👍 112 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class OnlineElection{
  public static void main(String[] args) {
//    TopVotedCandidate solution = new OnlineElection().new TopVotedCandidate();
//    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class TopVotedCandidate {
    int[] times,win;
    public TopVotedCandidate(int[] persons, int[] times) {
      int index;
      int n=times.length;
      this.times=times;
      this.win=new int[n];
      this.win[0]=persons[0];
      int[] count=new int[n];
      count[persons[0]]++;
      for(int i=1;i<n;i++){
        count[persons[i]]++;
        this.win[i]=count[win[i-1]]>count[persons[i]]?win[i-1]:persons[i];
      }
    }
    public int q(int t) {
      int index=Arrays.binarySearch(times,t);
      if(index<0){
        index=-index-2;
      }
      return this.win[index];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
//leetcode submit region end(Prohibit modification and deletion)

}