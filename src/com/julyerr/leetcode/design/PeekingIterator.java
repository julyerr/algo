package com.julyerr.leetcode.design;

import java.util.Iterator;

/*
 * 参考思路：https://www.bbsmax.com/A/A2dmRgAzen/
 * peek指向下一个elem
 * */
public class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    //    是否提前调用next
    boolean flag;
    Integer peek;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!flag) {
            peek = iterator.next();
            flag = true;
        }
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (flag) {
            flag = false;
            return peek;
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        if (flag) {
            return true;
        }
        return iterator.hasNext();
    }
}
