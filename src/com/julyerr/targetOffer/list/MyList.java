package com.julyerr.targetOffer.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class MyList {
    private ListNode head, tail;

    public MyList() {
        head = tail = new ListNode();
    }

    public void add(Integer data) {
        tail.next = new ListNode(data);
        tail = tail.next;
    }

    public Integer remove() {
        if (isEmpty()) {
            return null;
        }
        ListNode p = head;
        while (p.next != tail) {
            p = p.next;
        }
        Integer ret = p.next.data;
        p.next = null;
        tail = p;
        return ret;
    }

    public List traversal() {
        List list = new ArrayList();
        if (isEmpty()) {
            return list;
        }
        ListNode p = head;
        while (p.next != null) {
            list.add(p.next.data);
            p = p.next;
        }
        return list;
    }

    public List reverseTraversal() {
        List list = new ArrayList();
        if (isEmpty()) {
            return list;
        }
        ListNode p = head;
        Stack stack = new Stack();
        while (p.next != null) {
            stack.add(p.next.data);
            p = p.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void prin(List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer data = (Integer) iterator.next();
            System.out.print(data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyList myList = new MyList();
        int[] nums = new int[]{1, 2, 3};
        for (int i = 0; i < nums.length; i++) {
            myList.add(nums[i]);
        }
        myList.prin(myList.traversal());
        myList.prin(myList.reverseTraversal());
        myList.remove();
        myList.prin(myList.traversal());
        myList.prin(myList.reverseTraversal());
    }
}
