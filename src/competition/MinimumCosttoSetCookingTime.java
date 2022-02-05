package competition;

import java.util.*;
import java.lang.*;


public class MinimumCosttoSetCookingTime {
    public static void main(String[] args) {
        Solution solution = new MinimumCosttoSetCookingTime().new Solution();
        System.out.println(solution.minCostSetTime(0,100000,100000,6039));
    }
    
    class Solution {
        public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
            int ans;
            int minutes = targetSeconds / 60;
            int seconds = targetSeconds % 60;
            
            int ansT = 0;
            int cur = startAt;
            if (0 < minutes && minutes < 10) {
                if (cur != minutes)
                    ansT += moveCost + pushCost;
                else
                    ansT += pushCost;
                cur = minutes;
            } else if (10 <= minutes && minutes<100) {
                int decade = (minutes / 10) % 10;
                int bit = minutes % 10;
                if (cur != decade)
                    ansT += moveCost + pushCost;
                else
                    ansT += pushCost;
                cur = decade;
                if (cur != bit)
                    ansT += moveCost + pushCost;
                else
                    ansT += pushCost;
                cur = bit;
            }
            int decade = (seconds / 10) % 10;
            int bit = seconds % 10;
            if(minutes==0 && decade==0){
                if (cur != bit)
                    ansT += moveCost + pushCost;
                else
                    ansT += pushCost;
                cur = bit;
            }else if(minutes<100){
                if (cur != decade)
                    ansT += moveCost + pushCost;
                else
                    ansT += pushCost;
                cur = decade;
                if (cur != bit)
                    ansT += moveCost + pushCost;
                else
                    ansT += pushCost;
                cur = bit;
            }
            
            ans = ansT==0?Integer.MAX_VALUE:ansT;
            ansT = 0;
            cur = startAt;
            if (minutes > 0 && seconds <= 39) {
                minutes--;
                seconds += 60;
                if (0 < minutes && minutes < 10) {
                    if (cur != minutes)
                        ansT += moveCost + pushCost;
                    else
                        ansT += pushCost;
                    cur = minutes;
                } else if (10 <= minutes && minutes<100) {
                    decade = (minutes / 10) % 10;
                    bit = minutes % 10;
                    if (cur != decade)
                        ansT += moveCost + pushCost;
                    else
                        ansT += pushCost;
                    cur = decade;
                    if (cur != bit)
                        ansT += moveCost + pushCost;
                    else
                        ansT += pushCost;
                    cur = bit;
                }
                decade = (seconds / 10) % 10;
                bit = seconds % 10;
                if(minutes==0 && decade==0){
                    if (cur != bit)
                        ansT += moveCost + pushCost;
                    else
                        ansT += pushCost;
                    cur = bit;
                }else if(minutes<100){
                    if (cur != decade)
                        ansT += moveCost + pushCost;
                    else
                        ansT += pushCost;
                    cur = decade;
                    if (cur != bit)
                        ansT += moveCost + pushCost;
                    else
                        ansT += pushCost;
                    cur = bit;
                }
    
                return Math.min(ans,ansT);
            }else
                return ans;

        }
    }
    
}
