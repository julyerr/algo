package com.julyerr.leetcode.list;


public class OddEvent {
    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = head.next;
        ListNode rHead = right;
        ListNode p = right.next;
        while (p != null && p.next != null) {
            left.next = p;
            left = left.next;
            right.next = p.next;
            right = right.next;
            p = right.next;
        }
        if (p != null) {
            left.next = p;
            left = left.next;
        }
        left.next = rHead;
        right.next = null;
        return head;
    }
}
