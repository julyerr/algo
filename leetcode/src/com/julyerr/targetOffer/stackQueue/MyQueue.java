package com.julyerr.targetOffer.stackQueue;

import java.util.Stack;

/**
 * 用两个栈，实现队列的从队尾插入元素offer()和从队头抛出元素poll()
 *
 * 自己实现的时候，stack1中内容不需要pop入stack0中，每次操作反而效率很低
 * 原作者，保留stack1中内容，只有stack1中为空的情况下才进行stack0 -> stack1 的操作
 *
 * bonus:
 * 对于poll情况，队列为空没有必要抛出异常，直接返回null即可，友好一点
 * 最好增加泛型实现
 */
public class MyQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                int tmp = stack1.pop();
                stack2.push(tmp);
            }
            return stack2.pop();
        }
        return -1;
    }

    public static void main(String[] args){
        MyQueue main  = new MyQueue();
        int[] nums = new int[]{1,2,3,4,5,6};
        for (int i = 0; i < nums.length; i++) {
            main.push(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(main.pop()+" ");
        }
        System.out.println();

    }
}
