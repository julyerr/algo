package com.julyerr.leetcode.list;

import com.julyerr.leetcode.searchSort.ListNode;

public class PalindromeList {
    public boolean isPalindrome(ListNode head) {
//        check validation
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

//        找到中间节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

//        翻转后部分
        ListNode tail = reverseListComm(slow);

//        迭代比较
//        notes:如果设置成head!=tail，会发生空指针引用的异常，中间的tail = null
        while (head != slow) {
            if (head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    public static ListNode reverseListComm(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tmp = head.next;
        ListNode newHead = reverseListComm(head.next);
        tmp.next = head;
        head.next = null;
        return newHead;
    }
}
