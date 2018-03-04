package com.julyerr.leetcode.list;

import com.julyerr.leetcode.searchSort.ListNode;

public class AddTwoNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

//        设置临时ListNode
        ListNode head = new ListNode(0);
        ListNode p = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
//            fetch the first elem from l1
            int val1 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }

//            fetch the first elem from l2
            int val2 = 0;
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }

//            更新zhi
            int tmp = val1 + val2 + carry;
            carry = tmp / 10;
            p.next = new ListNode(tmp % 10);
            p = p.next;
        }
        if (carry != 0) {
            p.next = new ListNode(carry);
        }
        return head.next;
    }
}
