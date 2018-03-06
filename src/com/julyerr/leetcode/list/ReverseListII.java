package com.julyerr.leetcode.list;

import com.julyerr.leetcode.searchSort.ListNode;

public class ReverseListII {
    //    m,n 题目明确说明valid
    public ListNode reverseBetween(ListNode head, int m, int n ) {
        if (head == null || head.next == null || m==n) {
            return head;
        }

//        为了方便操作，设置临时头结点
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;


//        保留pre
        ListNode pre = null;
        //        记录起始和结束node
        ListNode start = tmpHead.next;
        ListNode end = tmpHead.next;
        while (m-- > 0) {
            pre = start;
            start = start.next;
            end = end.next;
            n--;
        }
        while (n-- > 0) {
            end = end.next;
        }

//        保留tail
        ListNode tail = end.next;
        start.next = null;

//        反转并拼接
        pre.next = PalindromeList.reverseListComm(start);
        end.next = tail;

        return tmpHead.next;
    }
}
