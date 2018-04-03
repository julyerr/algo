package com.julyerr.realInterview.exams.netease.neitui2018;

import java.util.Scanner;

/*
* 最大相邻不相等字符串长度
* */
public class MaxLen01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int max = 0;
            int len = line.length();
            for (int i = 0; i < len; i++) {
                int tmp = 1;
//                不相等的时候增加长度
                while (i + 1 < len && line.charAt(i) != line.charAt(i + 1)) {
                    tmp++;
                    i++;
                }
                max = Math.max(max, tmp);
            }
            System.out.println(max);
        }
    }
}
