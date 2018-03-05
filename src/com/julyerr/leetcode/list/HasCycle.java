package com.julyerr.leetcode.list;

import com.julyerr.leetcode.searchSort.ListNode;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
//        check validation
        if(head == null || head.next == null){
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&& fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}
