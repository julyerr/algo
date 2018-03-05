package com.julyerr.leetcode.list;

import com.julyerr.leetcode.searchSort.ListNode;

public class HasCycleII {
    public ListNode detectCycle(ListNode head) {
//        check validation
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
//        查找相遇节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
//        不存在环的情况
        if (fast == null || fast.next == null) {
            return null;
        }

//        共同走X步
        ListNode p = head;
        while (p != fast) {
            p = p.next;
            fast = fast.next;
        }
        return fast;
    }
}
