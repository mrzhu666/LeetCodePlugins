package competition;

import java.util.*;
import java.lang.*;

public class FindThreeConsecutiveIntegersThatSumtoaGivenNumber {
    public static void main(String[] args) {
    
    }
    class Solution {
        public long[] sumOfThree(long num) {
            if(num%3!=0)
                return new long[0];
            else
                return new long[]{num/3-1,num/3,num/3+1};
        }
    }
}