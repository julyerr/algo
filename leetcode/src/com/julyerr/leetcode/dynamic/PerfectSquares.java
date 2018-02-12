package com.julyerr.leetcode.dynamic;

import java.util.Arrays;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
 * which sum to n.
 * <p>
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */

/**
 * 比较巧妙，很难想到
 */
public class PerfectSquares {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for (int i = 0; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        return dp[n];
    }
}
