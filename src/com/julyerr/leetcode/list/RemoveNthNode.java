package com.julyerr.leetcode.list;

import com.julyerr.leetcode.searchSort.ListNode;

public class RemoveNthNode {
    //    题目明确n是有效的，因此不需要判断n的范围
    public ListNode removeNthFromEnd(ListNode head, int n) {
//        check n if necessary
        if (head == null) {
            return head;
        }

//        设置临时头结点
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;

        ListNode fast = tmpHead;
//        先走N步
        while (n-- > 0) {
            fast = fast.next;
        }
        ListNode pre = tmpHead;

//        迭代到fast到末端
        while (fast.next != null) {
            fast = fast.next;
            pre = pre.next;
        }
//        移除对应节点
        pre.next = pre.next.next;

        return tmpHead.next;
    }
}
