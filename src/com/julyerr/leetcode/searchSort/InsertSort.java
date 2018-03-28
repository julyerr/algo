package com.julyerr.leetcode.searchSort;

/**
 * Sort a linked list using insertion searchSort.
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
            //reserve the cur next Node
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