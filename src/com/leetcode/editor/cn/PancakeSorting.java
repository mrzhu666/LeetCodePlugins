package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class PancakeSorting{
  public static void main(String[] args) {
    Solution solution = new PancakeSorting().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans=new ArrayList<>();
        int n=arr.length;
        for(int i=n-1;i>=0;i--){
            if(arr[i]==i+1) continue;
            if(arr[0]==i+1){
                reverse(arr,i);
                ans.add(i+1);
                continue;
            }
            for(int j=1;j<i;j++){
                if(arr[j]==i+1){
                    reverse(arr,j);
                    ans.add(j+1);
                    reverse(arr,i);
                    ans.add(i+1);
                }
            }
        }
        return ans;
    }
    public void reverse(int[] arr,int index){
        int left=0,right=index;
        for(;left<right;left++,right--){
            int tmp=arr[left];
            arr[left]=arr[right];
            arr[right]=tmp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}