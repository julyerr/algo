package com.julyerr.realInterview.exams.kuaishou.chuzhao2018;

import java.util.Scanner;

public class XY {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            long n = scanner.nextLong();
            long tmp = x;
            long sum = 1;
//            for (int i = 0; i < 63; i++) {
//                if ((y & ((long)1 << i)) != 0) {
//                    sum *= tmp;
//                }
//                tmp = tmp * tmp;
//            }
//            System.out.println(sum % n);
            System.out.println(pow(x, y) % n);
        }
    }

    private static long pow(long a, long b) {
        long rt = 1;
        for (long i = b; i != 0; i /= 2) {
            if (i % 2 != 0) {
                rt *= a;
            }
            a *= a;
        }

        return rt;
    }
}
