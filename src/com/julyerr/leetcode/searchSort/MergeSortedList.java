package com.julyerr.leetcode.searchSort;

public class MergeSortedList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        check validation
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

//        设置临时节点
        ListNode tmpHead = new ListNode(0);
        ListNode cur = tmpHead;

        ListNode p = l1;
        ListNode q = l2;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }
//        剩余部分合并
        if (p != null) {
            cur.next = p;
        }
        if (q != null) {
            cur.next = q;
        }
        return tmpHead.next;
    }
}
