package competition;

import java.util.*;
import java.lang.*;


public class MinimumCosttoSetCookingTime {
    public static void main(String[] args) {
        Solution solution = new MinimumCosttoSetCookingTime().new Solution();
        System.out.println(solution.minCostSetTime(0, 100000, 100000, 6039));
    }
    
    class Solution {
        int moveCost;
        int pushCost;
        
        // 计算花费
        public int movePush(int cur, int target) {
            if (cur != target)
                return moveCost + pushCost;
            else
                return pushCost;
        }
        
        // 计算输入该分钟和秒需要的花费
        public int calculate(int startAt, int minutes, int seconds) {
            int ans = 0;
            int cur = startAt;
            if (0 < minutes && minutes < 10) {
                ans += movePush(cur, minutes);
                cur = minutes;
            } else if (10 <= minutes && minutes < 100) {
                int decade = (minutes / 10) % 10;
                int bit = minutes % 10;
                ans += movePush(cur, decade);
                cur = decade;
                ans += movePush(cur, bit);
                cur = bit;
            }
            int decade = (seconds / 10) % 10;
            int bit = seconds % 10;
            if (minutes == 0 && decade == 0) {
                ans += movePush(cur, bit);
            } else if (minutes < 100) {
                ans += movePush(cur, decade);
                cur = decade;
                ans += movePush(cur, bit);
            }
            return ans == 0 ? Integer.MAX_VALUE : ans;
        }
        
        public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
            this.moveCost = moveCost;
            this.pushCost = pushCost;
            int minutes = targetSeconds / 60;
            int seconds = targetSeconds % 60;
            
            int ans = calculate(startAt, minutes, seconds);
            
            if (minutes > 0 && seconds <= 39) {
                minutes--;
                seconds += 60;
                ans = Math.min(ans, calculate(startAt, minutes, seconds));
            }
            return ans;
            
        }
    }
    
}
