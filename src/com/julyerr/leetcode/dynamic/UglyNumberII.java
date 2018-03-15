package com.julyerr.leetcode.dynamic;

/**
 * Write a program to find the n-th ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * <p>
 * Note that 1 is typically treated as an ugly number.
 */

/**
 * 通过设置dp数组，维护不同的下标，针对变化往后移动一位即可
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        if (n < 2) {
            return n;
        }
//        其中dp[i]表示下标为i+1对应的ugly number
        int[] dp = new int[n];
        dp[0] = 1;
        int step0 = 0;
        int step1 = 0;
        int step2 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[step0] * 2, Math.min(dp[step1] * 3, dp[step2] * 5));
            dp[i] = min;
            if (min == dp[step0] * 2) {
                step0++;
            }
            if (min == dp[step1] * 3) {
                step1++;
            }
            if (min == dp[step2] * 5) {
                step2++;
            }
        }
        return dp[n - 1];
    }
}
