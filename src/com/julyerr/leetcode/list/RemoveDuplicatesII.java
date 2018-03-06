package com.julyerr.leetcode.list;

import com.julyerr.leetcode.searchSort.ListNode;

public class RemoveDuplicatesII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;

        ListNode p = tmpHead;
//        两级next比较
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                ListNode tmp = p.next.next;
//                寻找新值，或者出现null
                while (tmp != null && tmp.val == p.next.val) {
                    tmp = tmp.next;
                }
                p.next = tmp;
            } else {
                p = p.next;
            }
        }

        return tmpHead.next;
    }
}
