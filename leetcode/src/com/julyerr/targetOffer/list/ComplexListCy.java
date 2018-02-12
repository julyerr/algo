package com.julyerr.targetOffer.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

/**
 * 直接思考分别处理random和next比较复杂，可以分开来先处理next将基本的链表结构建立完善之后；
 * 利用map的一一对应的关系，调整random即可
 */
public class ComplexListCy {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
//        check validation
        if (pHead == null) {
            return null;
        }
        //    建立一一映射的关系
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode p = pHead;
        RandomListNode newHead = new RandomListNode(p.label);
        map.put(p, newHead);
        RandomListNode q = newHead;
        p = p.next;
        while (p != null) {
            q.next = new RandomListNode(p.label);
            q = q.next;
            map.put(p, q);
            p = p.next;
        }

        p = pHead;
        q = newHead;
        do {
            if (p.random != null) {
                q.random = map.get(p.random);
            }
            p = p.next;
            q = q.next;
        } while (p != null);
        return newHead;
    }
}
