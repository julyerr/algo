package com.julyerr.niuke;

import java.util.Scanner;

/*
 * 自己写的代码还是不够简洁，参考大神的
 * */
public class AverCarry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n <= 2) {
                System.out.println(1 + "/" + "1");
                continue;
            }
            int sum = 0;
//            直接求余数即可
            for (int i = 2; i < n; i++) {
                int m = n;
                while (m > 0) {
                    sum += m % i;
                    m /= i;
                }
            }
            int gcdD = gcd(sum, n - 2);
            System.out.println(sum / gcdD + "/" + (n - 2) / gcdD);
        }
    }

    //    最大公因数，欧几里得算法
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
