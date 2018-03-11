package com.julyerr.leetcode.dynamic;

public class NumOfTreesI {
    public int numTrees(int n) {
        if (n < 3) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = 0;
//            统计以不同元素为root的情况数
            for (int j = 0; j < i; j++) {
                tmp += dp[j] * dp[i - 1 - j];
            }
            dp[i] = tmp;
        }
        return dp[n];
    }
}
