package com.leetcode.editor.cn;

//Given a string text, you want to use the characters of text to form as many 
//instances of the word "balloon" as possible. 
//
// You can use each character in text at most once. Return the maximum number 
//of instances that can be formed. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: text = "nlaebolko"
//Output: 1
// 
//
// Example 2: 
//
// 
//
// 
//Input: text = "loonbalxballpoon"
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: text = "leetcode"
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= text.length <= 10⁴ 
// text consists of lower case English letters only. 
// 
// Related Topics 哈希表 字符串 计数 👍 90 👎 0


import java.util.*;
import java.lang.*;

public class MaximumNumberOfBalloons {
    public static void main (String[] args){
        Solution solution = new MaximumNumberOfBalloons().new Solution();
        System.out.println(solution);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxNumberOfBalloons(String text) {
        String target="balloon";
        int[] tarCh=new int[26];
        int[] textCh=new int[26];
        for(char ch:target.toCharArray())
            tarCh[ch-'a']++;
        for(char ch:text.toCharArray())
            textCh[ch-'a']++;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<26;i++)
            if(tarCh[i]!=0)
                ans=Math.min(ans,textCh[i]/tarCh[i]);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}

