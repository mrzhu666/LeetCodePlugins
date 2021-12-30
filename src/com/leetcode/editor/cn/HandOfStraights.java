//Alice has some number of cards and she wants to rearrange the cards into 
//groups so that each group is of size groupSize, and consists of groupSize 
//consecutive cards. 
//
// Given an integer array hand where hand[i] is the value written on the iᵗʰ 
//card and an integer groupSize, return true if she can rearrange the cards, or 
//false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
//Output: true
//Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
// 
//
// Example 2: 
//
// 
//Input: hand = [1,2,3,4,5], groupSize = 4
//Output: false
//Explanation: Alice's hand can not be rearranged into groups of 4.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= hand.length <= 10⁴ 
// 0 <= hand[i] <= 10⁹ 
// 1 <= groupSize <= hand.length 
// 
//
// 
// Note: This question is the same as 1296: https://leetcode.com/problems/
//divide-array-in-sets-of-k-consecutive-numbers/ 
// Related Topics 贪心 数组 哈希表 排序 👍 145 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HandOfStraights{
  public static void main(String[] args) {
    Solution solution = new HandOfStraights().new Solution();
    System.out.print(solution.isNStraightHand(new int[]{53,78,62,108,83,56,66,110,49,104,117,123,86,131,94,107,84,103,42,127,100,50,55,97,81,93,71,45,63,39,91,87,129,126,84,125,73,95,116,47,106,52,121,54,38,68,69,76,89,90,57,67,86,114,64,87,79,92,115,60,51,105,132,101,59,130,44,85,80,82,48,65,128,102,74,61,40,46,98,111,109,119,72,43,112,120,58,113,77,88,41,118,75,85,124,122,96,83,99,70},50));
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
      int n=hand.length;
      if(n%groupSize!=0)
        return false;

      Map<Integer,Long> count= Arrays.stream(hand).boxed().collect(Collectors.groupingBy(e->e,TreeMap::new,Collectors.counting()));
//      Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
//      for (int x : hand) {
//        cnt.put(x, cnt.getOrDefault(x, 0) + 1);
//      }

      for(int i:count.keySet()){
        long value=count.get(i);
        if(value==0) continue;

        for(int j=i;j<i+groupSize;j++){
          if(value<=count.getOrDefault(j,0L))
            count.put(j,count.get(j)-value);
          else
            return false;
        }
      }
      return true;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

  class Solution1 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
      int n=hand.length;
      if(n%groupSize!=0)
        return false;

      Map<Integer,Long> count= Arrays.stream(hand).boxed().collect(Collectors.groupingBy(e->e,TreeMap::new,Collectors.counting()));

      Deque<Map.Entry<Integer,Long>> q=new ArrayDeque<>();
      for(Map.Entry<Integer, Long> i:count.entrySet()){
        q.addLast(i);
        if(q.size()==groupSize){
          Map.Entry<Integer,Long> entryFirst=q.pollFirst();
          if(entryFirst.getValue()==0)
            continue;
          int consec=1;
          for(Map.Entry<Integer,Long> j:q){
            if(entryFirst.getKey()+consec!=j.getKey())
              return false;
            consec++;
            if(entryFirst.getValue()<=j.getValue())
              j.setValue(j.getValue()-entryFirst.getValue());
            else
              return false;
          }
          System.out.println(count);
        }

      }
      for(Map.Entry<Integer,Long> j:q)
        if(j.getValue()!=0)
          return false;

      return true;
    }
  }
}