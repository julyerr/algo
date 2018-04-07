package com.julyerr.realInterview.exams.netease.qiuzhao2017;

import java.util.Scanner;

/*
 * 使用动态规划，same[i] 表示i长的字符串后面两个字母相同，diff[i]表示i长的字符串后面两个字母不相同
 * 容易发现：
 *  same[i] = same[i - 1] + diff[i - 1];
 *  diff[i] = 2 * same[i - 1] + diff[i - 1];
 * */

public class DarkStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            long[] same = new long[n + 1];
            long[] diff = new long[n + 1];
            same[2] = 3;
            diff[2] = 6;
            for (int i = 3; i <= n; i++) {
                same[i] = same[i - 1] + diff[i - 1];
                diff[i] = 2 * same[i - 1] + diff[i - 1];
            }
            System.out.println(same[n] + diff[n]);
        }
    }
}
