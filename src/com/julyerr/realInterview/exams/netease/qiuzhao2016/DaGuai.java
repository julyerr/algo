package com.julyerr.realInterview.exams.netease.qiuzhao2016;

import java.util.Scanner;

public class DaGuai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int init = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int tmp = scanner.nextInt();
                if (init >= tmp) {
                    init += tmp;
                } else {
                    init += gcd(tmp, init);
                }
            }
            System.out.println(init);
        }
    }

    private static int gcd(int n, int m) {
        if (n % m == 0) {
            return m;
        }
        return gcd(m, n % m);
    }
}
