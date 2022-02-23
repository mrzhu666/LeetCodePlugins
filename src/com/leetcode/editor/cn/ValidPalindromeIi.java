package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;
import DataStructure.*;


public class ValidPalindromeIi{
  public static void main(String[] args) {
    Solution solution = new ValidPalindromeIi().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public boolean isParlindrome(String s,int left,int right){
          while(left<right){
              if(s.charAt(left)!=s.charAt(right))
                  return false;
              left++;right--;
          }
          return true;
      }
    public boolean validPalindrome(String s) {
        int left=0,right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return isParlindrome(s, left + 1, right) || isParlindrome(s, left, right-1);
            }
            left++;right--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}