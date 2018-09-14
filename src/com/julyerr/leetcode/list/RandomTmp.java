package com.julyerr.leetcode.list;

import com.julyerr.targetOffer.list.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomTmp {
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public RandomTmp(ListNode head) {
        list = new ArrayList<>();
        random = new Random();
        ListNode p = head;
        while(p !=null){
            list.add(p.data);
            p = p.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int n = random.nextInt(list.size());
        return list.get(n);
    }

    List<Integer> list;
    Random random;

    public static void main(String[] args){
        // 初始化一个单链表 [1,2,3].
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        RandomTmp solution = new RandomTmp(head);

// getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
        System.out.println(solution.getRandom());;
    }
}
