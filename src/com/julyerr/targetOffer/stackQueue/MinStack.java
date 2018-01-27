package com.julyerr.targetOffer.stackQueue;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。要求在该栈中，调用min，push及pop的时间复杂度都是o(1)。
 */

import java.util.Stack;

/**
 * 解题思路：
 * blog:http://www.cnblogs.com/javawebsoa/archive/2013/05/21/3091727.html
 * 通过设置两个stack的方式，minStack只存储最小值：
 * push的时候，只push更小的value
 * pop的时候，判断top是否为pop的元素，判断是否需要pop出
 */


//通常如果明确给出了需要什么时间复杂度之类的，正常操作不能达到的话，通过空间换时间的方式获得

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(Integer i) {
//        if both empty
        if (stack.isEmpty()) {
            stack.push(i);
            minStack.push(i);
            return;
        }
//        compare to see whether to push
        if (minStack.peek() >= i) {
            minStack.push(i);
        }
        stack.push(i);
    }

    public Integer pop() {
//        invalid
        if (stack.isEmpty()) {
            return -1;
        }
//        需要pop的元素在minStack中存在，同样pop
        if (stack.peek() == minStack.peek()) {
            minStack.pop();
        }
        return stack.pop();
    }

    public Integer min() {
        if (stack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        int[] nums = new int[]{10, 8, 3, 0, 1};
        System.out.println("push begin");
        for (int i = 0; i < nums.length; i++) {
            minStack.push(nums[i]);
            System.out.println(minStack.min());
        }
        System.out.println("pop begin");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(minStack.min());
            minStack.pop();
        }
    }
}
