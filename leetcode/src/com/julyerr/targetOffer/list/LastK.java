package com.julyerr.targetOffer.list;

import java.util.List;

/**
 * 求链表中倒数第k个节点。链表的尾节点定义为倒数第1个节点。
 */
public class LastK {
    public ListNode FindKthToTail(ListNode head, int k) {
//        这种方式遍历了两遍
        //        if (k <= 0 || head == null) {
//            return null;
//        }
//        ListNode p = head;
//        int count = 0;
//        while (p != null) {
//            p = p.next;
//            count++;
//        }
//
//        if (k > count) {
//            return null;
//        }
//        count -= k;
//        p = head;
//        while (count != 0) {
//            p = p.next;
//            count--;
//        }
//        return p;

        //    比较好的解决方式是使用前后两个指针，分别移动位置
//        对于k大于整个长度的情况可以一致性处理
        if (k <= 0 || head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode post = head;
        while (pre != null && k != 0) {
            k--;
            pre = pre.next;
        }
        if (pre == null) {
            if (k == 0) {
                return post;
            } else {
                return null;
            }
        }
        while (pre != null) {
            pre = pre.next;
            post = post.next;
        }
        return post;

    }
}
