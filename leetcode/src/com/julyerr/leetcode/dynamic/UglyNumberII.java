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
    public int uglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int l1, l2, l3;
        l1 = l2 = l3 = 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int min = 1;
        for (int i = 2; i <= n; i++) {
            min = Math.min(dp[l1] * 2, Math.min(dp[l2] * 3, dp[l3] * 5));
            dp[i] = min;
            if (min == dp[l1] * 2) {
                l1++;
            }
            if (min == dp[l2] * 3) {
                l2++;
            }
            if (min == dp[l3] * 5) {
                l3++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        UglyNumberII uglyNumberII = new UglyNumberII();
        System.out.println(uglyNumberII.uglyNumber(11));
    }
}
