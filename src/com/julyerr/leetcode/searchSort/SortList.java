package com.julyerr.leetcode.searchSort;

public class SortList {
    private ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = split(head);
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(mid);
       return MergeSortedList.mergeTwoLists(node1,node2);
    }

    private ListNode split(ListNode head){
        if(head == null || head.next==null){
            return head;
        }

//        设置快慢指针
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPre = null;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slowPre = slow;
            slow = slow.next;
        }

        slowPre.next = null;
        return slow;
    }
}
