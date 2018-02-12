package com.julyerr.targetOffer.list;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */

/**
 * 这道题中间有很多坑，面试的时候不可能像平台一样允许多次提交查看结果（基本上提交就是提交了）
 * 如果保证代码的正确性和完整性？需要去总结错题，针对性的避免这部分坑
 */
public class FirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
//        check validation
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int len1 = 0;
        int len2 = 0;
        ListNode p = pHead1;
        while (p != null) {
            len1++;
            p = p.next;
        }

        ListNode q = pHead2;
        while (q != null) {
            len2++;
            q = q.next;
        }

        p = pHead1;
        q = pHead2;
        while (len1 > len2) {
            p = p.next;
            len1--;
        }
        while (len2 > len1) {
            q = q.next;
            len2--;
        }
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
