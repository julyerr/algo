package com.julyerr.leetcode.stack;

import java.util.Stack;

public class ValidaPareness {
    public boolean isValid(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == ']') {
                    if (stack.pop() != '[') {
                        return false;
                    }
                } else if (c == ')') {
                    if (stack.pop() != '(') {
                        return false;
                    }
                } else {
                    if (c == '}') {
                        if (stack.pop() != '{') {
                            return false;
                        }
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
