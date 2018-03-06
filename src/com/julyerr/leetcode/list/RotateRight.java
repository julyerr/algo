package com.julyerr.leetcode.list;

import com.julyerr.leetcode.searchSort.ListNode;

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

//        记录链表的长度，p为末端
        int length = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            length++;
        }

//        k可能超过链表的长度，需要取余数
        k = k % length;

//        未发生变化
        if (k == 0) {
            return head;
        }

//        找到新的末端节点
        ListNode tail = head;
        for (int i = 0; i < length - k - 1; i++) {
            tail = tail.next;
        }

//        构成环
        p.next = head;
        ListNode ret = tail.next;

//        截断环
        tail.next = null;

        return ret;

    }
}
