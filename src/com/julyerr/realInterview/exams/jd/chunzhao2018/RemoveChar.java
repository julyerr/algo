package com.julyerr.realInterview.exams.jd.chunzhao2018;

import java.util.Scanner;

public class RemoveChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            System.out.println(ways(line));
        }
    }

    private static long ways(String string) {
        if (string.length() <= 1) {
            return 1;
        }
        int len = string.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i <= len; i++) {
            for (int j = 2; j <= len; j++) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
                for (int k = 1; k < j; k++) {
                    if (string.charAt(k - 1) == string.charAt(j - 1)) {
                        dp[i][j] += ways(string.substring(k, j-1));
                    }
                }
            }
        }
        long sum = 0;
        for (int i = 1; i <= len; i++) {
            sum += dp[len][i];
        }
        return sum;
    }
}
