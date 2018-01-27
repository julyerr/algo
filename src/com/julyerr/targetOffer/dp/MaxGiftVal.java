package com.julyerr.targetOffer.dp;

/**
 * 在一个m*n的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于0）。
 * 从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。
 * 给定一个棋盘，求拿到礼物的最大价值。例如，对于如下棋盘
 */
public class MaxGiftVal {
    public int maxGiftVal(int[][] gifts) {
//                check validation
        if (gifts == null || gifts.length == 0 || gifts[0].length == 0) {
            return 0;
        }
        int rowNum = gifts.length;
        int colNum = gifts[0].length;
        int[][] dp = new int[rowNum][colNum];
        int sum = 0;
        for (int i = 0; i < colNum; i++) {
            dp[0][i] = sum + gifts[0][i];
            sum = dp[0][i];
        }
        sum = 0;
        for (int i = 0; i < rowNum; i++) {
            dp[i][0] = sum + gifts[i][0];
            sum = dp[i][0];
        }
        for (int i = 1; i < rowNum; i++) {
            for (int j = 1; j < colNum; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + gifts[i][j];
            }
        }

        return dp[rowNum - 1][colNum - 1];
    }

    public static void main(String[] args) {
        MaxGiftVal maxGiftVal = new MaxGiftVal();
        int[][] nums = new int[][]{
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };

        System.out.println(maxGiftVal.maxGiftVal(nums));
    }
}
