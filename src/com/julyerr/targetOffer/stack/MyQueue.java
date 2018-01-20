package com.julyerr.targetOffer.stack;

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
public class MyQueue<T> {
    private Stack<T> stack0;
    private Stack<T> stack1;

    public MyQueue() {
        stack0 = new Stack<T>();
        stack1 = new Stack<T>();
    }

    public boolean isEmpty(){
        return stack0.isEmpty();
    }

    public void offer(T i){
        stack0.add(i);
    }

//    public int poll() throws Exception {
//        if(isEmpty()){
//            throw new Exception("no elem");
//        }
//        while(!stack0.isEmpty()){
//            stack1.add(stack0.pop());
//        }
//        int tmp = stack1.pop();
//        while(!stack1.isEmpty()){
//            stack0.add(stack1.pop());
//        }
//        return tmp;
//    }

    public T poll(){
        if(!stack1.isEmpty()){
            return stack1.pop();
        }else if(!stack0.isEmpty()){
            while(!stack0.isEmpty()){
                stack1.add(stack0.pop());
            }
            return stack1.pop();
        }
        return null;
    }

    public static void main(String[] args){
        MyQueue<Integer> myQueue = new MyQueue();
        int[] nums = new int[]{1,2,3};
        for (int i = 0; i < nums.length; i++) {
            myQueue.offer(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(myQueue.poll());
        }
        System.out.println(myQueue.poll());
    }
}
