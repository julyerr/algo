package com.julyerr.leetcode.dynamic;

/**
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest square containing all 1's and return its area.
 * <p>
 * For example, given the following matrix:
 */

/**
 * 为了减少时间复杂度，对于矩阵通常使用前到后顺序而不是从后到前顺序进行遍历
 * 这篇文章讲的很详细：http://www.cnblogs.com/thoupin/p/4780352.html
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int xLen = matrix.length;
        int yLen = matrix[0].length;
        int[][] dp = new int[xLen][yLen];

//        设置max正确初始值
        int max = 0;
//        对第一行和第一列进行初始化
        for (int i = 0; i < xLen; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                max = 1;
            }
        }

        for (int i = 0; i < yLen; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                max = 1;
            }
        }

        for (int i = 1; i < xLen; i++) {
            for (int j = 1; j < yLen; j++) {
//                只有在1的情况下才设置值，并且更新
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
