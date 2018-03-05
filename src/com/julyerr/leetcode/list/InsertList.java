package com.julyerr.leetcode.list;

import com.julyerr.leetcode.searchSort.ListNode;

public class InsertList {
    public ListNode insertionSortList(ListNode head) {
//        check validation
        if(head == null || head.next == null){
            return head;
        }

//        临时头结点
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;

        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!=null){
//            需要调整指针
            if(cur.val<pre.val){
                ListNode p = cur;
                cur = cur.next;
                pre.next = cur;

//                找到插入位置
                ListNode tmp = tmpHead;
                while(tmp.next!=pre && p.val > tmp.next.val ){
                    tmp = tmp.next;
                }
                p.next = tmp.next;
                tmp.next = p;
            }else{
//            next while loop
                pre = pre.next;
                cur = cur.next;
            }
        }
        return tmpHead.next;
    }

    public static void main(String[] args){
        InsertList insertList = new InsertList();
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);

        ListNode tmp = insertList.insertionSortList(head);
    }
}
