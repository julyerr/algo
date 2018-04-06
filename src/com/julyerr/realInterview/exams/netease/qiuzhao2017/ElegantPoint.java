package com.julyerr.realInterview.exams.netease.qiuzhao2017;

import java.util.Scanner;

public class ElegantPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int times = 0;
            int tmp = (int) Math.sqrt(n);
            if (tmp * tmp == n) {
                tmp--;
                times += 4;
            }
            for (int i = 1; i <= tmp; i++) {
                int tmpMinus = n - i * i;
                int a = (int) Math.sqrt(tmpMinus);
                if (a * a == tmpMinus) {
                    times += 4;
                }
            }
            System.out.println(times);
        }
    }
}
