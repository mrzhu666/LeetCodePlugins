package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;
import DataStructure.*;

public class LinkedListCycleIi{
  public static void main(String[] args) {
    Solution solution = new LinkedListCycleIi().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode cur=head;
        Set<ListNode> set=new HashSet<>();
        while(cur!=null){
            if(set.contains(cur))
                return cur;
            set.add(cur);
            cur=cur.next;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public class Solution1 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head,slow=head;
        int fastCnt=0,slowCnt=0;
        while(fast!=null){
            fast=fast.next;
            if(fast==null) return null;
            fast=fast.next;
            slow=slow.next;
            fastCnt+=2;slowCnt++;
            if(fast==slow) break;
        }
        if(fast==null)return null;
        int m=fastCnt-2*slowCnt;
        ListNode cur=head;
        for(;m>0;m--)
            head=head.next;
        return head;
    }
}
}