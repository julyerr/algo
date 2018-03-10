package com.julyerr.niuke;

import java.util.Scanner;

/*
 * 解题思路和上题进制的平均和基本类似
 * */
public class CarryLockuNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int ret = 0;

            for (int i = 1; i <= n; i++) {

                int sum1 = 0;
                int tmp1 = i;
                while (tmp1 > 0) {
                    sum1 += tmp1 % 10;
                    tmp1 /= 10;
                }

                int sum2 = 0;
                int tmp2 = i;
                while (tmp2 > 0) {
                    sum2 += (tmp2 & 1);
                    tmp2 >>= 1;
                }

                if (sum1 == sum2) {
                    ret++;
                }
            }

            System.out.println(ret);
        }
    }
}
