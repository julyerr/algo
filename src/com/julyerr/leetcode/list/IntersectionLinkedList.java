package com.julyerr.leetcode.list;

import com.julyerr.leetcode.searchSort.ListNode;

public class IntersectionLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        check validation
        if (headA == null || headB == null) {
            return null;
        }

//        计算各自的长度
        ListNode pA = headA;
        int aLen = 0;
        while (pA != null) {
            pA = pA.next;
            aLen++;
        }

        ListNode pB = headB;
        int bLen = 0;
        while (pB != null) {
            pB = pB.next;
            bLen++;
        }

//        各自最后一个节点不相同
        if (pA != pB) {
            return null;
        }

        ListNode p = headA;
        ListNode q = headB;
        while (aLen > bLen) {
            aLen--;
            p = p.next;
        }
        while (aLen < bLen) {
            bLen--;
            q = q.next;
        }

        while (p != q) {
            p = p.next;
            q = q.next;
        }

        return p;
    }
}
