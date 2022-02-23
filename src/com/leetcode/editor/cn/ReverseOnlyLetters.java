package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;
import DataStructure.*;


public class ReverseOnlyLetters{
  public static void main(String[] args) {
    Solution solution = new ReverseOnlyLetters().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseOnlyLetters(String s) {
        StringBuilder ans=new StringBuilder();
        int n=s.length();
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(!Character.isLetter(s.charAt(i)))
                q.add(new int[]{i,s.charAt(i)});
        }
        int right=n-1;
        for(int i=0;i<n;i++){
            if(!Character.isLetter(s.charAt(i)))
                ans.append(s.charAt(i));
            else{
                while(!Character.isLetter(s.charAt(right)))
                    right--;
                ans.append(s.charAt(right));
                right--;
            }
            
        }
        
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}