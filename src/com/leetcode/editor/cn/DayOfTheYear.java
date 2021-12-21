//Given a string date representing a Gregorian calendar date formatted as YYYY-
//MM-DD, return the day number of the year. 
//
// 
// Example 1: 
//
// 
//Input: date = "2019-01-09"
//Output: 9
//Explanation: Given date is the 9th day of the year in 2019.
// 
//
// Example 2: 
//
// 
//Input: date = "2019-02-10"
//Output: 41
// 
//
// Example 3: 
//
// 
//Input: date = "2003-03-01"
//Output: 60
// 
//
// Example 4: 
//
// 
//Input: date = "2004-03-01"
//Output: 61
// 
//
// 
// Constraints: 
//
// 
// date.length == 10 
// date[4] == date[7] == '-', and all other date[i]'s are digits 
// date represents a calendar date between Jan 1st, 1900 and Dec 31, 2019. 
// 
// Related Topics 数学 字符串 👍 71 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class DayOfTheYear{
  public static void main(String[] args) {
    Solution solution = new DayOfTheYear().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int dayOfYear(String date) {
      String[] s=date.split("-");
      int year=Integer.parseInt(s[0]);
      int month=Integer.parseInt(s[1]);
      int day=Integer.parseInt(s[2]);
      for(int i=1;i<month;i++){
        if(i==2){
          if(year%4==0) day+=29;
          else day+=28;
        }
        else if(i<8){
          if(i%2==1) day+=31;
          else day+=30;
        }
        else{
          if(i%2==1) day+=30;
          else day+=31;
        }
      }
      return day;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}