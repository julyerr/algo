package com.julyerr.leetcode.dynamic;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */

//解题思路和maximalSquare类似，只是在增加上对应的是path[i][j]，同时不能包含左上方的元素的值
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
//        check validation,should not happen here
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
//        初始化操作
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += grid[0][i];
            dp[0][i] = sum;
        }

        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += grid[i][0];
            dp[i][0] = sum;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }
}
