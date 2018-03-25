package com.julyerr.realInterview.dp;

import java.util.Scanner;

/*
 * 参考解题思路:https://blog.csdn.net/whing123/article/details/78149032
 *
 * 有两种方式递归和动态规划
 * */

public class WaysOfLay {
    private static int m, n, count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            count = 0;
            m = scanner.nextInt();
            n = scanner.nextInt();
            System.out.println(dfs(m, n));
        }
    }

    private static int dfs(int appleNum, int diskNum) {
        if (appleNum == 0 || diskNum == 1) {
            return 1;
        }
//        苹果数量小于盘子的数量，去掉多余的空盘子
        if (appleNum < diskNum) {
            return dfs(appleNum, appleNum);
        }
//        苹果数量大于盘子数量，种类数=有一个空盘和没有空盘（每个盘子去掉一个苹果）
        return dfs(appleNum, diskNum - 1) + dfs(appleNum - diskNum, diskNum);
    }

    //    dp[i][j] 表示i个苹果放入j个盘子中
    private static int dp(int appleNum, int diskNum) {
        int[][] dp = new int[appleNum + 1][diskNum + 1];
        for (int i = 0; i < appleNum + 1; i++) {
            for (int j = 0; j < diskNum + 1; j++) {
                dp[i][j] = 1;
            }
        }

        for (int i = 2; i < appleNum + 1; i++) {
            for (int j = 2; j < diskNum + 1; j++) {
//                处理过程和上面dfs思路一致
                if (i < j) {
                    dp[i][j] = dp[i][i];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - j][j];
                }
            }
        }
        return dp[appleNum][diskNum];
    }
}
