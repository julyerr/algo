package com.julyerr.realInterview.exams.netease.chunzhao2017;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/*
 * 开始看错了题目
 * */

public class BasicCal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c >= '0' && c <= '9') {
                    int tmp = c - '0';
                    if (stack.isEmpty()) {
                        stack.add(tmp);
                    } else {
                        int ops = stack.pop();
                        int pre = stack.pop();
                        if(ops == 0){
                            tmp+= pre;
                        }else if(ops ==1){
                            tmp = pre - tmp;
                        }else{
                            tmp *= pre;
                        }
                        stack.add(tmp);
                    }
                } else if (c == '+') {
                    stack.add(0);
                } else if (c == '-') {
                    stack.add(1);
                } else if (c == '*') {
                    stack.add(2);
                }
            }
            System.out.println(stack.pop());
        }
    }
}
