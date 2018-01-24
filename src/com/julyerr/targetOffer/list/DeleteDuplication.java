package com.julyerr.targetOffer.list;

/**
 * 在一个排序的链表中，存在重复的结点
 * 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

/**
 * 解题思路还是比较巧妙的，先判断是否相等后循环跳过元素
 */
public class DeleteDuplication {
    public ListNode<Integer> deleteDuplication(ListNode<Integer> pHead) {
        ListNode<Integer> head = new ListNode<>();
        head.next = pHead;
        ListNode<Integer> p = head;
        while (p.next != null) {
            ListNode<Integer> q = p.next.next;
            if (q == null || q.data != p.next.data) {
                p = p.next;
            } else {
                do {
                    q = q.next;
                } while (q != null && q.data == p.next.data);
                p.next = q;
            }
        }
        return head.next;
    }
}
