package com.julyerr.leetcode.dynamic;

/*
 * 参考资料：https://blog.csdn.net/geekmanong/article/details/51056375
 * */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                int tmp = 0;
                if (s.charAt(j) == s.charAt(j + i)) {
                    tmp = dp[j + 1][j + i - 1] + 2;
                } else {
                    tmp = Math.max(dp[j + 1][j + i], dp[j][i + j - 1]);
                }
                dp[j][i + j] = tmp;
            }
        }
        return dp[0][n - 1];
    }
}

