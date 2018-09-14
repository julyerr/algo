package com.julyerr.leetcode.stack;

import java.util.Collections;
import java.util.Stack;

public class BasicCalII {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int length = s.length();
//        使用一个stack的时候，需要将符号表示为数字存储
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int tmp = c - '0';
                while (i + 1 < length && Character.isDigit(s.charAt(i + 1))) {
//                    tmp *= 10+s.charAt(++i)-'0' 出错，先计算10+s.char(++i)-'0'后才是相乘操作
                    tmp = tmp * 10 + s.charAt(++i) - '0';
                }
//                进行乘除运算
                if (!stack.isEmpty() && (stack.peek() == 2 || stack.peek() == 3)) {
                    int sign = stack.pop();
                    int val = stack.pop();

                    if (sign == 2) {
                        val = val * tmp;
                    } else {
                        val = val / tmp;
                    }
                    stack.push(val);
                } else {
                    stack.push(tmp);
                }
            } else {
                switch (c) {
                    case '+':
                        stack.push(0);
                        break;
                    case '-':
                        stack.push(1);
                        break;
                    case '*':
                        stack.push(2);
                        break;
                    case '/':
                        stack.push(3);
                        break;
                }
            }
        }

//        进行加减运算,出栈和入栈顺序相反
        Collections.reverse(stack);

        if (stack.isEmpty()) {
            return 0;
        }

//        重复利用已经计算好的结果
        int ret = stack.pop();
        while (!stack.isEmpty()) {
            int signed = stack.pop();
            int b = stack.pop();
            if (signed == 0) {
                ret += b;
            } else {
                ret -=b;
            }
        }
        return ret;
    }

    public static void main(String[] args){
        BasicCalII basicCalII = new BasicCalII();
        String string = "42";
        System.out.println(basicCalII.calculate(string));
    }
}
