package com.julyerr.leetcode.stack;

import java.util.Collections;
import java.util.Stack;

public class SimplyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }

        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
//            不进行处理
            if (s.equals("") || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }

//        如果出现空的情况
        if (stack.isEmpty()) {
            return "/";
        }

//        栈和正常的顺序相反
        Collections.reverse(stack);
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append("/");
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }
}
