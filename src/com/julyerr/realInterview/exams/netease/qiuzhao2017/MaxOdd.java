package com.julyerr.realInterview.exams.netease.qiuzhao2017;

import java.util.Scanner;

/*
 * 主要考虑的是简化操作次数
 *
 * 可以预先计算出1-n中所有奇数和；
 * 针对偶数，每个数除2之后又相当于1-n/2的一个序列，便想到使用dfs
 * */
public class MaxOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(dfs(n));
        }
    }

    private static long dfs(long input) {
        if (input == 1) {
            return 1;
        }
        long rt = 0;
//        input为奇数
        if ((input & 1) != 0) {
            rt = rt + ((1 + input) * (input + 1) >> 2);
//        input 为偶数
        } else {
            rt = rt + (input * input >> 2);
        }
//        递归计算
        return rt + dfs(input / 2);
    }
}
