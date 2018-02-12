package com.julyerr.leetcode.sort;

/**
 * Sort a linked list using insertion sort.
 */
public class InsertSort {
    public ListNode insertSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode pre = newHead;
            //reserve the cur next node
            ListNode next = cur.next;
            while (pre.next != null && pre.next.val <= cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return newHead.next;
    }
}
