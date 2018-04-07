package com.julyerr.realInterview.exams.toutiao.shixi0324;


import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/*
 * 主要是表达式的计算，leetcode上的类似的题目
 *
 * 先计算*,/然后计算+,-
 * */
public class ShowNums {
    private static String[][] strings = new String[][]{
            {
                    "66666",
                    "6...6",
                    "6...6",
                    "6...6",
                    "66666"
            },
            {
                    "....6",
                    "....6",
                    "....6",
                    "....6",
                    "....6",
                    "....6"
            },
            {
                    "66666",
                    "....6",
                    "66666",
                    "6....",
                    "66666"
            },
            {
                    "66666",
                    "....6",
                    "66666",
                    "....6",
                    "66666"
            },
            {
                    "6...6",
                    "6...6",
                    "66666",
                    "....6",
                    "....6",
            },
            {
                    "66666",
                    "6....",
                    "66666",
                    "....6",
                    "66666",
            },
            {
                    "66666",
                    "6....",
                    "66666",
                    "6...6",
                    "66666",
            },
            {
                    "66666",
                    "....6",
                    "....6",
                    "....6",
                    "....6",
            },
            {
                    "66666",
                    "6...6",
                    "66666",
                    "6...6",
                    "66666",
            },
            {
                    "66666",
                    "6...6",
                    "66666",
                    "....6",
                    "66666",
            },

    };

    private static void showNum(int n){
        String num = new String(n+"");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < num.length(); j++) {
                stringBuilder.append(strings[num.charAt(j)-'0'][i]);
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Stack<Integer> stack = new Stack<>();
            int length = line.length();
            for (int i = 0; i < length; i++) {
                char c = line.charAt(i);
                if (Character.isDigit(c)) {
                    int tmp = c - '0';
                    while (i + 1 < length && Character.isDigit(line.charAt(i + 1))) {
                        tmp = tmp * 10 + line.charAt(i + 1) - '0';
                        i++;
                    }
                    if (stack.isEmpty() || stack.peek() != 2) {
                        stack.add(tmp);
                    } else {
                        stack.pop();
                        tmp *= stack.pop();
                        stack.push(tmp);
                    }
                } else if (c == '*') {
                    stack.add(2);
                } else if (c == '+') {
                    stack.add(1);
                } else if (c == '-') {
                    stack.add(-1);
                }
            }
            Collections.reverse(stack);
            int rt = stack.pop();
            while (!stack.isEmpty()) {
                int signed = stack.pop();
                int pre = stack.pop();
                if (signed == -1) {
                    rt -= pre;
                } else {
                    rt += pre;
                }
            }
            showNum(rt);
        }
    }
}
