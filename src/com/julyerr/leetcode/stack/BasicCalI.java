package com.julyerr.leetcode.stack;

import java.util.Scanner;
import java.util.Stack;

public class BasicCalI {
    public int calculate(String s) {
//        check validation
        if (s == null || s.length() == 0) {
            return 0;
        }

//        计算结果
        int ret = 0;
//        后面的操作数是否是有符号
        int signed = 1;
//        操作数栈
        Stack<Integer> ops = new Stack<>();

        int length = s.length();
        //        迭代整个字符串
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '+') {
                signed = 1;
            } else if (c == '-') {
                signed = -1;
            } else if (Character.isDigit(c)) {
                int tmp = c - '0';
                while (i + 1 < length && Character.isDigit(s.charAt(i + 1))) {
                    tmp *= 10 + s.charAt(++i) - '0';
                }
                ret += signed * tmp;

//               压栈操作
            } else if (c == '(') {
                ops.push(ret);
                ops.push(signed);
//                重新进行下轮计算
                ret = 0;
                signed = 1;
//                合并计算结果
            } else if (c == ')') {
                ret = ret * ops.pop() + ops.pop();
                signed = 1;
            }
        }
        return ret;
    }

    public static void main(String args[]) {
        BasicCalI basicCalI = new BasicCalI();
        String string = "(1+(4+5+2)-3)+(6+8)";
//        String string = "1 + 1";
        System.out.println(basicCalI.calculate(string));
    }
}
