package com.julyerr.leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysParenthness {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> rt = new ArrayList<>();
        if (input.length() == 0) {
            return rt;
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
//            将符号的左右字符串划分为不同的两部分
            if (c == '+' || c == '-' || c == '*') {
                String firsPart = input.substring(0, i);
                String secondPart = input.substring(i + 1);
                for (Integer first :
                        diffWaysToCompute(firsPart)) {
                    for (Integer second :
                            diffWaysToCompute(secondPart)) {
                        int tmp = 0;
                        switch (c) {
                            case '+':
                                tmp = first + second;
                                break;
                            case '-':
                                tmp = first - second;
                                break;
                            case '*':
                                tmp = first * second;
                                break;
                        }
                        rt.add(tmp);
                    }
                }
            }
        }
//        如果没有运算符的话，只存在数字，可以作为结果返回
        if (rt.size() == 0) {
            rt.add(Integer.parseInt(input));
        }
        return rt;
    }
}
