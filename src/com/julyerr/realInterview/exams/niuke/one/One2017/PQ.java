package com.julyerr.realInterview.exams.niuke.one.One2017;

import java.util.Scanner;

/*
 * 参考大神的解题思路：https://blog.csdn.net/zjkc050818/article/details/65935032
 *
 * 求解p^q =n,其中p为素数，由于范围太大，直接枚举素数效率太低，因此考虑枚举幂指数然后判断相应的p是否为素数
 * */
public class PQ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long n = scanner.nextLong();
//            幂指数的范围为(2，log2(n))，log2(n)<=sqrt(n)
            boolean finished = false;
            for (long i = 2; i * i <= n; i++) {
                long tmp = (long) Math.pow(n, 1.0 / i);
                if (Math.pow(tmp,i) == n && isPrime(tmp)) {
                    System.out.println((int) tmp + " " + i);
                    finished = true;
                    break;
                }
            }
            if (!finished) {
                System.out.println("No");
            }
        }
    }

    private static boolean isPrime(long p) {
        for (long i = 2; i <= Math.sqrt(p); i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;
    }
}
