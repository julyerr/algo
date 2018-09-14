package com.julyerr.realInterview.exams.xiechen0329.qiu_2018;

import java.util.HashMap;
import java.util.Map;

public class LRUF {
    class Node {
        Node pre;
        Node next;
        Integer key;
        Integer val;

        Node(Integer k, Integer v) {
            key = k;
            val = v;
        }
    }

    Map<Integer, Node> map = new HashMap<Integer, Node>();
    // The head (eldest) of the doubly linked list.
    Node head;
    // The tail (youngest) of the doubly linked list.
    Node tail;
    int cap;

    public LRUF(int capacity) {
        cap = capacity;
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node n = map.get(key);
        if (n != null) {
            //拎出来节点
            n.pre.next = n.next;
            n.next.pre = n.pre;
            appendTail(n);
            return n.val;
        }
        return -1;
    }

    public void set(int key, int value) {
        Node n = map.get(key);
        // existed
        if (n != null) {
            n.val = value;
            map.put(key, n);
            return;
        }
        // else {
        if (map.size() == cap) {
            Node tmp = head.next;
            head.next = head.next.next;
            head.next.pre = head;
            map.remove(tmp.key);
        }
        n = new Node(key, value);
        // youngest node append taill
        appendHead(n);

        map.put(key, n);
    }

    private void appendTail(Node n) {
        n.next = tail;
        n.pre = tail.pre;
        tail.pre.next = n;
        tail.pre = n;
    }

    private void appendHead(Node n){
        head.next.pre = n;
        n.next = head.next;
        head.next = n;
        n.pre = head;
    }
}