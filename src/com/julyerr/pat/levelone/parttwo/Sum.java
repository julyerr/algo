package com.julyerr.pat.levelone.parttwo;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            long[][] nums = new long[n][2];
            long b = 1;
            for (int i = 0; i < n; i++) {
                String[] strings = scanner.next().split("/");
                nums[i][0] = Long.parseLong(strings[0]);
                nums[i][1] = Long.parseLong(strings[1]);
                if (b % nums[i][1] != 0) {
                    b *= nums[i][1];
                }
            }
            long a = 0;
            for (int i = 0; i < n; i++) {
                a = a + b / nums[i][1] * nums[i][0];
            }
            System.out.println(format(a, b));
        }
    }

    private static long gcd(long a, long b) {
        if (a < b) {
            long tmp = a;
            a = b;
            b = tmp;
        }
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    private static String format(long a, long b) {
        if (a == 0) {
            return "0";
        }
        boolean minus = false;
        if (a < 0 && b > 0 || a > 0 && b < 0) {
            minus = true;
        }
        a = Math.abs(a);
        b = Math.abs(b);
        String rt = minus ? "-" : "";
        if (a >= b) {
            long tmp = a / b;
            a = a - tmp * b;
            if (a == 0) {
                return rt + tmp;
            }
            rt += tmp + " ";
        }
        long c = gcd(a, b);
        return rt + (a / c) + "/" + (b / c);
    }
}

/*
5
2/5 4/15 1/30 -2/60 8/3
* */
