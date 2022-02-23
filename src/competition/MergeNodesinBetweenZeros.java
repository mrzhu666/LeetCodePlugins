package competition;

import java.util.*;
import java.lang.*;

public class MergeNodesinBetweenZeros {
    public static void main(String[] args) {
        
    }
    
    public class ListNode {
        int val;
        ListNode next;
        
        ListNode() {
        }
        
        ListNode(int val) {
            this.val = val;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeNodes(ListNode head) {
            ListNode cur=new ListNode(0);
            ListNode anshead=cur;
            
            head=head.next;
            while(head!=null){
                if(head.val==0 && head.next!=null){
                    cur.next=new ListNode(0);
                    cur=cur.next;
                }else if(head.val!=0){
                    cur.val+=head.val;
                }
                head=head.next;
            }
            return anshead;
        }
    }
}