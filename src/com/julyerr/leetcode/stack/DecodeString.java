package com.julyerr.leetcode.stack;

import java.util.Stack;

/*
* 解题思路：http://www.cnblogs.com/grandyang/p/5849037.html
* 符号栈和数字栈
* */
public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> opsStack = new Stack<>();
        int num = 0;
        String t = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else {
                if (c == '[') {
                    numStack.add(num);
                    num = 0;
                    opsStack.add(t);
                    t = "";
                } else if (c == ']') {
                    int times = numStack.pop();
                    StringBuilder pre = new StringBuilder(opsStack.pop());
                    for (int j = 0; j < times; j++) {
                        pre.append(t);
                    }
                    t = pre.toString();
                } else {
                    t += String.valueOf(c);
                }
            }
        }
        return t;
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
//        System.out.println(decodeString.decodeString("3[a]2[bc]"));
        System.out.println(decodeString.decodeString("3[a2[c]a]"));
    }
}
