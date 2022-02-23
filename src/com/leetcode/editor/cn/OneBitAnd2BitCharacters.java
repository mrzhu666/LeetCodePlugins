package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class OneBitAnd2BitCharacters {
    public static void main(String[] args) {
        Solution solution = new OneBitAnd2BitCharacters().new Solution();
        System.out.print(solution);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean dfs(int[] bits,int cur){
            if(cur==0)
                return bits[cur]==0;
            if(cur==1)
                return !(bits[cur]==1 && bits[cur-1]==0);
            if(bits[cur]==1 && bits[cur-1]==0)
                return false;
            if(bits[cur]==0)
                if(dfs(bits,cur-1))
                    return true;
            if(bits[cur-1]==1)
                if(dfs(bits,cur-2))
                    return true;
            
            return false;
        }
        public boolean isOneBitCharacter(int[] bits) {
            if(bits.length==1) return true;
            return dfs(bits,bits.length-2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}