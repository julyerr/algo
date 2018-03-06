package com.julyerr.leetcode.list;

import com.julyerr.leetcode.searchSort.ListNode;

public class SwapInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next== null){
            return head;
        }

//        设置临时头结点，方便操作
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;

        ListNode p = tmpHead;
        ListNode nextStep = null;
        while(p!=null && p.next!=null && p.next.next!=null){
            nextStep = p.next.next.next;

            ListNode tmp = p.next;
            p.next = p.next.next;
            p.next.next = tmp;
            tmp.next = nextStep;
//            下一次跌地
            p = tmp;
        }

        return tmpHead.next;
    }
}
