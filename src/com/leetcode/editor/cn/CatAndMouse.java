//A game on an undirected graph is played by two players, Mouse and Cat, who 
//alternate turns. 
//
// The graph is given as follows: graph[a] is a list of all nodes b such that 
//ab is an edge of the graph. 
//
// The mouse starts at node 1 and goes first, the cat starts at node 2 and goes 
//second, and there is a hole at node 0. 
//
// During each player's turn, they must travel along one edge of the graph that 
//meets where they are. For example, if the Mouse is at node 1, it must travel to 
//any node in graph[1]. 
//
// Additionally, it is not allowed for the Cat to travel to the Hole (node 0.) 
//
// Then, the game can end in three ways: 
//
// 
// If ever the Cat occupies the same node as the Mouse, the Cat wins. 
// If ever the Mouse reaches the Hole, the Mouse wins. 
// If ever a position is repeated (i.e., the players are in the same position 
//as a previous turn, and it is the same player's turn to move), the game is a draw.
// 
// 
//
// Given a graph, and assuming both players play optimally, return 
//
// 
// 1 if the mouse wins the game, 
// 2 if the cat wins the game, or 
// 0 if the game is a draw. 
// 
//
// 
// Example 1: 
//
// 
//Input: graph = [[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]
//Output: 0
// 
//
// Example 2: 
//
// 
//Input: graph = [[1,3],[0],[3],[0,2]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 3 <= graph.length <= 50 
// 1 <= graph[i].length < graph.length 
// 0 <= graph[i][j] < graph.length 
// graph[i][j] != i 
// graph[i] is unique. 
// The mouse and the cat can always move. 
// 
// Related Topics 广度优先搜索 图 记忆化搜索 数学 动态规划 博弈 👍 148 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class CatAndMouse{
  public static void main(String[] args) {
    Solution solution = new CatAndMouse().new Solution();
    System.out.print(solution.catMouseGame(new int[][]{{2,5},{3},{0,4,5},{1,4,5},{2,3},{0,2,3}}
    ));
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    final int CAT_WIN=2;
    final int MOUSE_WIN=1;
    final int DRAW=0;
    int[][][] dp;
    int[][] graph;
    int n;
    public int catMouseGame(int[][] graph) {
      this.n=graph.length;
      dp=new int[n][n][2*n];
      this.graph=graph;
      for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
          Arrays.fill(dp[i][j],-1);

      return getResult(1,2,0);
    }
    public int getResult(int mouse,int cat,int num){
      if(mouse==0)
        return MOUSE_WIN;
      if(mouse==cat)
        return CAT_WIN;
      if(num==2*n)
        return DRAW;
      if(dp[mouse][cat][num]!=-1) return dp[mouse][cat][num];
      int curNode;
      // 当前移动的对象
      if(num%2==0)
        curNode=mouse;
      else
        curNode=cat;
      int defaultResult=curNode==cat?MOUSE_WIN:CAT_WIN;
      for(int nextNode:graph[curNode]){
        if(curNode==cat){
          if(nextNode==0) continue;
          int tmp=getResult(mouse,nextNode,num+1);
          if(tmp==CAT_WIN){
            defaultResult=tmp;
            break;
          }else if(tmp==DRAW)
            defaultResult=tmp;
        }else{
          int tmp=getResult(nextNode,cat,num+1);
          if(tmp==MOUSE_WIN){
            defaultResult=tmp;
            break;
          }else if(tmp==DRAW)
            defaultResult=tmp;
        }
      }
      dp[mouse][cat][num]=defaultResult;
      return defaultResult;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}