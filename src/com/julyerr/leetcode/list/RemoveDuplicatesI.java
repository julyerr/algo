package com.julyerr.leetcode.list;

import com.julyerr.leetcode.searchSort.ListNode;

public class RemoveDuplicatesI {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }

        ListNode p = head;
        while(p.next!=null){
           if(p.next.val==p.val){
               ListNode tmp = p.next;
//               下一个不相等的节点或者null
               while(tmp!=null && tmp.val == p.val){
                   tmp = tmp.next;
               }
               p.next = tmp;
           }else{
               p = p.next;
           }
        }
        return head;
    }
}
