package com.julyerr.leetcode.list;

import com.julyerr.leetcode.searchSort.ListNode;
import com.julyerr.leetcode.tree.TreeNode;

public class SortedList {
    public TreeNode sortedListToBST(ListNode head) {
//        check validation
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode mid = cutMid(head);

//        查询中间节点，构建平衡树
        TreeNode node = new TreeNode(mid.val);
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }

    private ListNode cutMid(ListNode head) {
        if (head == null) {
            return null;
        }
        //        single node
        if (head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;

        ListNode slowPre = null;
//        查询设置slow为中间位置
        while (fast != null && fast.next != null) {
            slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
//        分成不相链的两部分
        slowPre.next = null;
        return slow;
    }
}
