package com.julyerr.targetOffer.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class BottomToTop {
    //    使用递归太长可能造成stackOverflow
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> rt = new ArrayList<>();
        if (listNode == null) {
            return rt;
        }
        printListFromTailToHead(listNode, rt);
        return rt;
    }

    private void printListFromTailToHead(ListNode node, List<Integer> list) {
        if (node != null) {
            printListFromTailToHead(node.next, list);
            list.add(node.data);
        }
    }
}
