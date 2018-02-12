package com.julyerr.leetcode.dynamic;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */

//解题思路和maximalSquare类似，只是在增加上对应的是path[i][j]，同时不能包含左上方的元素的值
public class MinimumPathSum {
    public int minimumPathSum(int[][] path) {
        if (path == null || path.length == 0 || path[0].length == 0) {
            return 0;
        }
        int m = path.length;
        int n = path[0].length;
        int[][] dp = new int[m][n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += path[0][i];
            dp[0][i] = sum;
        }
        sum = 0;
        for (int i = 0; i < m; i++) {
            sum += path[i][0];
            dp[i][0] = sum;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + path[i][j];
            }
        }
        return dp[m - 1][n - 1];

    }

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int[][] nums = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minimumPathSum.minimumPathSum(nums));
    }
}
