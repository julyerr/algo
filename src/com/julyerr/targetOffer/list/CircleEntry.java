package com.julyerr.targetOffer.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */

/**
 * 感觉自己的方法还是比较鸡肋的，通过map占用的内存比较大
 * 比较巧妙的方法是通过previous和font指针
 */
public class CircleEntry {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
//        使用map
        //        check validation
//        if (pHead == null) {
//            return null;
//        }
//        Map<ListNode, Integer> map = new HashMap<>();
//        ListNode p = pHead;
//        while (p != null) {
//            if (!map.containsKey(p)) {
//                map.put(p, 1);
//            } else {
//                return p;
//            }
//            p = p.next;
//        }
//        return null;


//        通过设置previous,front指针进行判断
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode previous = null;
        ListNode front = pHead.next;
        while (front != null) {
            previous.next = null;
            previous = front;
            front = front.next;
        }
        return previous;
    }
}
