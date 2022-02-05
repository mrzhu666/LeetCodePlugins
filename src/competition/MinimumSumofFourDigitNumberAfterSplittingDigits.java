package competition;

import java.util.*;
import java.lang.*;

public class MinimumSumofFourDigitNumberAfterSplittingDigits {
    public static void main (String[] args){
        Solution solution = new MinimumSumofFourDigitNumberAfterSplittingDigits().new Solution();
        System.out.println(solution);
    }
    
    class Solution {
        public int minimumSum(int num) {
            int[] ch=new int[4];
            ch[0]=num%10;
            ch[1]=(num/10)%10;
            ch[2]=(num/100)%10;
            ch[3]=(num/1000)%10;
            Arrays.sort(ch);
            return ch[0]*10+ch[3]+ch[1]*10+ch[2];
        }
    }
    
}
