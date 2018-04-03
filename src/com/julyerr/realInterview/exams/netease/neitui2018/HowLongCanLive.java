package com.julyerr.realInterview.exams.netease.neitui2018;

import java.util.Scanner;

/*
* 简单解方程
* */
public class HowLongCanLive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long x = scanner.nextLong();
            long f = scanner.nextLong();
            long d = scanner.nextLong();
            long p = scanner.nextLong();

            long count = d / x;
            if (count <= f) {
//                count += (f - d) / (x + p);
                System.out.println(count);
            } else {
                count = (d + f * p) / (p + x);
                System.out.println(count);
            }
        }
    }
}
