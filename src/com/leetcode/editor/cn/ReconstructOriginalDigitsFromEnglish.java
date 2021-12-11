//Given a string s containing an out-of-order English representation of digits 0
//-9, return the digits in ascending order. 
//
// 
// Example 1: 
// Input: s = "owoztneoer"
//Output: "012"
// Example 2: 
// Input: s = "fviefuro"
//Output: "45"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is one of the characters ["e","g","f","i","h","o","n","s","r","u","t",
//"w","v","x","z"]. 
// s is guaranteed to be valid. 
// 
// Related Topics 哈希表 数学 字符串 👍 90 👎 0


package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReconstructOriginalDigitsFromEnglish {
  public static void main(String[] args) {
    Solution solution = new ReconstructOriginalDigitsFromEnglish().new Solution();
    System.out.print(solution.originalDigits("esnve"));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int[] answer=new int[10];
    Map<Character, Long> letter;
    String[] nums = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    /**
     * 减去数字每个字母数量
     * @param ch 判断数字存在的字符
     * @param num 对应的数字
     */
    public void count(char ch,int num){
      if(letter.containsKey(ch) && letter.get(ch)!=0){
        long value=letter.get(ch);
        for(Character c:nums[num].toCharArray())
          letter.put(c,letter.get(c)-value);
        answer[num]+=value;
      }
    }
    public String originalDigits(String s) {
      letter = s.chars().boxed().collect(Collectors.groupingBy(i -> (char) i.intValue(), Collectors.counting()));
      count('g',8);
      count('u',4);
      count('w',2);
      count('x',6);
      count('z',0);

      count('f',5);
      count('h',3);
      count('s',7);
      count('o',1);
      count('i',9);


      StringBuilder answerString=new StringBuilder();
      for(int i=0;i<10;i++)
        for(int j=0;j<answer[i];j++){
          answerString.append(i);
        }
      return answerString.toString();
//      return IntStream.range(0,10).mapToObj(i->String.join("",Collections.nCopies(answer[i],""+i))).collect(Collectors.joining(""));
    }
  }
//leetcode submit region end(Prohibit modification and deletion)
//范例
//class Solution {
//  public String originalDigits(String s) {
//    char[] letters = new char[26];
//    int[] num = new int[10];
//    StringBuilder stringBuilder = new StringBuilder();
//    // 记录每个字母出现的频数
//    for(char c : s.toCharArray()){
//      letters[c - 'a'] ++;
//    }
//
//    num[0] = letters['z' - 'a'];
//    num[2] = letters['w' - 'a'];
//    num[4] = letters['u' - 'a'];
//    num[6] = letters['x' - 'a'];
//    num[8] = letters['g' - 'a'];
//    num[3] = letters['h' - 'a'] - num[8];
//    num[5] = letters['f' - 'a'] - num[4];
//    num[7] = letters['s' - 'a'] - num[6];
//    num[9] = letters['i' - 'a'] - num[5] - num[6] - num[8];
//    num[1] = letters['o' - 'a'] - num[0] - num[2] - num[4];
//
//    for(int i = 0;i < 10;i ++){
//      while(num[i] != 0){
//        stringBuilder.append(i);
//        num[i] --;
//      }
//    }
//    return stringBuilder.toString();
//  }
//}
}