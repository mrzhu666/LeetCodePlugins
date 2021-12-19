//Given an m x n matrix board where each cell is a battleship 'X' or empty '.', 
//return the number of the battleships on board. 
//
// Battleships can only be placed horizontally or vertically on board. In other 
//words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k 
//rows, 1 column), where k can be of any size. At least one horizontal or vertical 
//cell separates between two battleships (i.e., there are no adjacent battleships)
//. 
//
// 
// Example 1: 
//
// 
//Input: board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: board = [["."]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] is either '.' or 'X'. 
// 
//
// 
// Follow up: Could you do it in one-pass, using only O(1) extra memory and 
//without modifying the values board? 
// Related Topics 深度优先搜索 数组 矩阵 👍 156 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class BattleshipsInABoard{
  public static void main(String[] args) {
    Solution solution = new BattleshipsInABoard().new Solution();
    System.out.print(solution);
  }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int m;
    int n;
    int answer=0;
    char[][] board;
    public boolean dfs(int i,int j){
      if(i!=0 && j==0)
        return board[i-1][j]!='X';
      if(i==0 && j!=0)
        return board[i][j-1]!='X';
      if(i!=0 && j!=0)
        return board[i-1][j]!='X' && board[i][j-1]!='X';
      if(i==0 && j==0)
        return board[0][0]=='X';
      return true;
    }
    public int countBattleships(char[][] board) {
      m=board.length;
      n=board[0].length;
      this.board=board;
      for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
          if(board[i][j]=='X' && dfs(i,j))
            answer++;
      return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class Solution1 {
    int m;
    int n;
    int answer=0;
    char[][] board;
    public void dfs(int i,int j){
      if(!(0<=i && i<m && 0<=j && j<n)) return;
      if(board[i][j]!='X') return;
      board[i][j]='.';
      dfs(i+1,j);
      dfs(i,j+1);
    }
    public int countBattleships(char[][] board) {
      m=board.length;
      n=board[0].length;
      this.board=board;
      for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
          if(board[i][j]=='X'){
            dfs(i,j);
            answer++;
          }
      return answer;
    }
}


}