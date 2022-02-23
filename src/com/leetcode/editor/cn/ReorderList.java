package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;
import java.math.*;
import DataStructure.*;


public class ReorderList{
  public static void main(String[] args) {
    Solution solution = new ReorderList().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        Scanner scan = new Scanner(System.in);
        
        if(head.next==null) return;
        List<ListNode> array=new ArrayList<ListNode>();
        while (head != null) {
            array.add(head);
            head=head.next;
        }
        head=array.get(0);
        head.next=array.get(array.size()-1);
        int left=1,right=array.size()-2;
        while(left<right){
            array.get(right+1).next=array.get(left);
            array.get(left).next=array.get(right);
            left++;right--;
        }
        if(left==right) {
            array.get(right+1).next=array.get(right);
            array.get(right).next=null;
        }else{
            array.get(left).next=null;
        }
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}