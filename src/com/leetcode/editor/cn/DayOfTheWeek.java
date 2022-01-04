//Given a date, return the corresponding day of the week for that date. 
//
// The input is given as three integers representing the day, month and year 
//respectively. 
//
// Return the answer as one of the following values {"Sunday", "Monday", 
//"Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}. 
//
// 
// Example 1: 
//
// 
//Input: day = 31, month = 8, year = 2019
//Output: "Saturday"
// 
//
// Example 2: 
//
// 
//Input: day = 18, month = 7, year = 1999
//Output: "Sunday"
// 
//
// Example 3: 
//
// 
//Input: day = 15, month = 8, year = 1993
//Output: "Sunday"
// 
//
// 
// Constraints: 
//
// 
// The given dates are valid dates between the years 1971 and 2100. 
// 
// Related Topics 数学 👍 57 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class DayOfTheWeek{
  public static void main(String[] args) {
    Solution solution = new DayOfTheWeek().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
      String[] week=new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
      int ans=0;
      for(int i=1971;i<year;i++){
        if(i%4==0)
          ans=(ans+366)%7;
        else
          ans=(ans+365)%7;
      }
      for(int i=1;i<month;i++){
        if(i==2){
          if(year!=2100)
            ans=(ans+(year%4==0?29:28))%7;
          else
            ans=(ans+28)%7;
        }
        else if(i<=7)
          ans=(ans+(i%2==1?31:30))%7;
        else
          ans=(ans+(i%2==1?30:31))%7;
      }
      ans=(ans+day+4)%7;

      return week[ans];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}