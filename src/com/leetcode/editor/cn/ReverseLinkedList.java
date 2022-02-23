package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;
import DataStructure.*;


public class ReverseLinkedList{
  public static void main(String[] args) {
    Solution solution = new ReverseLinkedList().new Solution();
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
    public ListNode reverseList(ListNode head) {
        ListNode cur=head,tmp;
        ListNode rHead=null;
        while(cur!=null){
            tmp=cur;
            cur=cur.next;
            tmp.next=rHead;
            rHead=tmp;
        }
        return rHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}