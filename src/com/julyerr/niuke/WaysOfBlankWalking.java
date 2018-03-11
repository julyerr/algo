package com.julyerr.niuke;

import java.util.Scanner;

public class WaysOfBlankWalking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt()+1;
            int m = scanner.nextInt()+1;
            int[][] dp = new int[n][m];

            for (int i = 0; i < n; i++) {
                dp[i][0] = 1;
            }

            for (int i = 0; i < m; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
                }
            }
            System.out.println(dp[n - 1][m - 1]);
        }
    }
}
