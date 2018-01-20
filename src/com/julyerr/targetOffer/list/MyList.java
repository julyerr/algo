package com.julyerr.targetOffer.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class MyList<T> {
    private ListNode<T> head,tail;

    public MyList() {
        head = tail = new ListNode<T>();
    }

    public void add(T data){
        tail.next = new ListNode<>(data);
        tail = tail.next;
    }

    public T remove(){
        if(isEmpty()){
            return null;
        }
        ListNode<T> p = head;
        while(p.next != tail){
            p = p.next;
        }
        T ret = p.next.data;
        p.next = null;
        tail = p;
        return ret;
    }

    public List<T> traversal(){
        List<T> list = new ArrayList<>();
        if(isEmpty()){
            return list;
        }
        ListNode<T> p = head;
        while(p.next!=null){
            list.add(p.next.data);
            p = p.next;
        }
        return list;
    }

    public List<T> reverseTraversal(){
        List<T> list = new ArrayList<>();
        if(isEmpty()){
            return list;
        }
        ListNode<T> p = head;
        Stack<T> stack = new Stack<T>();
        while(p.next!=null){
            stack.add(p.next.data);
            p = p.next;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void prin(List<T> list){
        Iterator<T> iterator = list.iterator();
        while(iterator.hasNext()){
            T data = iterator.next();
            System.out.print(data+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        MyList<Integer> myList = new MyList<>();
        int[] nums = new int[]{1,2,3};
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
