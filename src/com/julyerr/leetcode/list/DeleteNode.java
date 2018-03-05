package com.julyerr.leetcode.list;

import com.julyerr.leetcode.searchSort.ListNode;

public class DeleteNode {
    public void deleteNode(ListNode node) {
//        check validation
        if (node == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
