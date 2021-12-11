//Given a Tic-Tac-Toe board as a string array board, return true if and only if 
//it is possible to reach this board position during the course of a valid tic-
//tac-toe game. 
//
// The board is a 3 x 3 array that consists of characters ' ', 'X', and 'O'. 
//The ' ' character represents an empty square. 
//
// Here are the rules of Tic-Tac-Toe: 
//
// 
// Players take turns placing characters into empty squares ' '. 
// The first player always places 'X' characters, while the second player 
//always places 'O' characters. 
// 'X' and 'O' characters are always placed into empty squares, never filled 
//ones. 
// The game ends when there are three of the same (non-empty) character filling 
//any row, column, or diagonal. 
// The game also ends if all squares are non-empty. 
// No more moves can be played if the game is over. 
// 
//
// 
// Example 1: 
//
// 
//Input: board = ["O  ","   ","   "]
//Output: false
//Explanation: The first player always plays "X".
// 
//
// Example 2: 
//
// 
//Input: board = ["XOX"," X ","   "]
//Output: false
//Explanation: Players take turns making moves.
// 
//
// Example 3: 
//
// 
//Input: board = ["XXX","   ","OOO"]
//Output: false
// 
//
// Example 4: 
//
// 
//Input: board = ["XOX","O O","XOX"]
//Output: true
// 
//
// 
// Constraints: 
//
// 
// board.length == 3 
// board[i].length == 3 
// board[i][j] is either 'X', 'O', or ' '. 
// 
// Related Topics 数组 字符串 👍 64 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class ValidTicTacToeState{
  public static void main(String[] args) {
    Solution solution = new ValidTicTacToeState().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public boolean validTicTacToe(String[] board) {
    int[] count=new int[2];
    for(String s:board){
      for(char ch:s.toCharArray()){
        if(ch=='X') count[0]+=1;
        if(ch=='O') count[1]+=1;
      }
    }
    if(count[0]-count[1]!=1 && count[0]-count[1]!=0){
      return false;
    }
    if(count[0]<3||count[1]<3) return true;
    String diagonal=""+board[0].charAt(0)+board[1].charAt(1)+board[2].charAt(2);
    String subDiagonal=""+board[0].charAt(2)+board[1].charAt(1)+board[2].charAt(0);
    if(diagonal.equals("OOO")||subDiagonal.equals("OOO")) return count[0]==count[1];
    if(diagonal.equals("XXX")||subDiagonal.equals("XXX")) return count[0]-count[1]==1;
    boolean first= Arrays.asList(board).contains("XXX");
    for(int i=0;i<3;i++) {
      int finalI = i;
      first|= Arrays.stream(board).allMatch(x->x.charAt(finalI)=='X');
    }
    boolean second= Arrays.asList(board).contains("OOO");
    for(int i=0;i<3;i++) {
      int finalI = i;
      second|= Arrays.stream(board).allMatch(x->x.charAt(finalI)=='O');
    }
    if(!first&&second)
      return count[0]==count[1];
    else if(first&&!second)
      return count[0]-count[1]==1;
    else
      return !(first&&second);
  }
}
//leetcode submit region end(Prohibit modification and deletion)
class Solution1 {
  public boolean validTicTacToe(String[] board) {
    int[] count=new int[2];
    for(String s:board){
      for(char ch:s.toCharArray()){
        if(ch=='X') count[0]+=1;
        if(ch=='O') count[1]+=1;
      }
    }
    if(count[0]-count[1]!=1 && count[0]-count[1]!=0){
      return false;
    }
    if(count[0]<3||count[1]<3) return true;
    String diagonal=""+board[0].charAt(0)+board[1].charAt(1)+board[2].charAt(2);
    String subDiagonal=""+board[0].charAt(2)+board[1].charAt(1)+board[2].charAt(0);
    if(diagonal.equals("OOO")||subDiagonal.equals("OOO")) return count[0]==count[1];
    if(diagonal.equals("XXX")||subDiagonal.equals("XXX")) return count[0]-count[1]==1;
    boolean first= Arrays.asList(board).contains("XXX");
    for(int i=0;i<3;i++) {
      int finalI = i;
      first|= Arrays.stream(board).allMatch(x->x.charAt(finalI)=='X');
    }
    boolean second= Arrays.asList(board).contains("OOO");
    for(int i=0;i<3;i++) {
      int finalI = i;
      second|= Arrays.stream(board).allMatch(x->x.charAt(finalI)=='O');
    }
    if(!first&&second)
      return count[0]==count[1];
    else if(first&&!second)
      return count[0]-count[1]==1;
    else
      return !(first&&second);
  }
}

}