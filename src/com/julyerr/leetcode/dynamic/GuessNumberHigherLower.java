package com.julyerr.leetcode.dynamic;

/*
 * 解题思路参考:https://blog.csdn.net/qq508618087/article/details/51991143
 * dp[i][j] 表示在i-j的范围内保证猜对最小数目
 * dp[i][j] = min(dp[i][j],k+max(dp[i][k],dp[k+1][j])),(i<=k<j)
 * */
public class GuessNumberHigherLower {
    public int getMoneyAmount(int n) {
        if (n <= 0) {
            return n;
        }
        int[][] dp = new int[n + 1][n + 1];
//        从大到小的过程顺便进行了初始化的操作（如果从小到大的话，
        for (int i = n - 1; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                int tmp = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    tmp = Math.min(tmp, k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }
                dp[i][j] = tmp;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        GuessNumberHigherLower guessNumberHigherLower = new GuessNumberHigherLower();
        System.out.println(guessNumberHigherLower.getMoneyAmount(3));
    }
}
