package com.julyerr.leetcode.list;

import java.util.HashMap;

public class CopyListWithRandom {
    private static class RandomListNode {
        int label;
        RandomListNode next, random;

        public RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode tmpHead = new RandomListNode(0);
        RandomListNode p = head,q=tmpHead;
//        使用hashmap的辅助结构存储
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        while(p!=null){
            q.next = new RandomListNode(p.label);
            q = q.next;
            map.put(p,q);
            p = p.next;
        }
        p = head;
        q = tmpHead.next;
        while(p!=null){
            if(p.random!=null){
                q.random = map.get(p.random);
            }
            q = q.next;
            p = p.next;
        }
        return tmpHead.next;
    }
}
