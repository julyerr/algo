package com.julyerr.targetOffer.list;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */

/**
 * 设置三个指针即可
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while (next != null) {
//            调整结构
            cur.next = pre;
//            更新位置
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;

        return cur;
    }
}
