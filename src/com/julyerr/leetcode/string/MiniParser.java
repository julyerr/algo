package com.julyerr.leetcode.string;

import java.util.Stack;

/*
 * 参考解题思路：https://juejin.im/entry/58a6970a8d6d81005827fdda
 * 这道题目的关键是理解NestedInteger代表的含义，如果是[]表示一定是一个NestedInteger开头的对象
 * */
public class MiniParser {
    public NestedInteger deserialize(String s) {
        if (isNumber(s.charAt(0))) {
            return new NestedInteger(Integer.parseInt(s));
        }
        Stack<NestedInteger> stack = new Stack<>();
        stack.push(new NestedInteger());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isNumber(c)) {
                int j = i;
                while (j < s.length() && isNumber(s.charAt(j))) {
                    j++;
                }
                stack.peek().add(new NestedInteger(Integer.parseInt(s.substring(i, j))));
//                下一次循环判断
                i = --j;
            } else {
                if (c == '[') {
                    stack.add(new NestedInteger());
                } else if (c == ']') {
                    NestedInteger tmp = stack.pop();
                    stack.peek().add(tmp);
                }
            }
        }
        return stack.pop();
    }

    private static class NestedInteger{
        NestedInteger data;

        public NestedInteger() {
        }

        public NestedInteger(int data) {

        }

        public void add(NestedInteger nestedInteger){}

    }

    private boolean isNumber(char c) {
        return Character.isDigit(c) || c == '-';
    }
}
