package com.julyerr.leetcode.stack;

import java.util.LinkedList;

public class MyStack {

    private LinkedList<Integer> queue ;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queue.isEmpty()){
            return -1;
        }
        return queue.removeLast();
    }

    /** Get the top element. */
    public int top() {
        return queue.peekLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
