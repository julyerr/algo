package com.julyerr.niuke.company.meituan;

import java.util.Arrays;
import java.util.Scanner;

/*
* 取N有多少种取法，动态规划，后面的结果叠加上相差一种货币面值的取法
* */
public class SumN {
    private static int[] kinds = new int[]{1, 5, 10, 20, 50, 100};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            long[] dp = new long[n + 1];
            Arrays.fill(dp, 1);
            for (int i = 1; i < kinds.length; i++) {
                for (int j = kinds[i]; j <= n; j++) {
                    dp[j] += dp[j - kinds[i]];
                }
            }
            System.out.println(dp[n]);
        }
    }
}
