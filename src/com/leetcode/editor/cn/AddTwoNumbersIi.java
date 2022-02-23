package com.leetcode.editor.cn;

import java.math.*;
import java.util.*;
import java.lang.*;
import DataStructure.*;


public class AddTwoNumbersIi{
  public static void main(String[] args) {
    Solution solution = new AddTwoNumbersIi().new Solution();
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigDecimal num1=new BigDecimal(0);
        BigDecimal num2=new BigDecimal(0);
        BigDecimal c=new BigDecimal(10);
        
        while(l1!=null){
            num1=num1.multiply(c);
            num1=num1.add(new BigDecimal(l1.val));
            l1=l1.next;
        }
        while(l2!=null){
            num2=num2.multiply(c);
            num2=num2.add(new BigDecimal(l2.val));
            l2=l2.next;
        }
        BigDecimal ans=num1.add(num2);
        char[] ch=ans.toString().toCharArray();
        ListNode head=new ListNode(ch[0]-'0');
        ListNode cur=head;
        for(int i=1;i<ch.length;i++){
            ListNode tmp=new ListNode(ch[i]-'0');
            cur.next=tmp;
            cur=tmp;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}