package com.julyerr.realInterview.exams.netease.neitui2018;

import java.util.Scanner;

/*
 * 参考大神的解题思路：https://www.nowcoder.com/questionTerminal/49375dd6a42d4230b0dc4ea5a2597a9b
 *
 * 使用动态规划，dp[i][j] 表示长度为i的序列以j为结束数字
 *
 * dp[i][j] = dp[i-1][m] (1<=m<=k)并且（m,j)是一个有效的序列
 *
 * 其中比较巧妙的一步，先统计出dp[i-1][m]的所有可能结果，然后减去不满足条件的情况数
 * */
public class LikedSeq {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[][] dp = new int[n + 1][k + 1];
            dp[0][1] = 1;
            for (int i = 1; i <= n; i++) {
                int sum = 0;
//                所有可能组合
                for (int j = 1; j <= k; j++) {
                    sum = (sum + dp[i - 1][j]) % MOD;
                }

                for (int j = 1; j <= k; j++) {
//                    删除所有不满足条件的情况，类似素数筛选的过程
                    int invalid = 0;
                    int p = 2;
                    while (p * j <= k) {
                        invalid = (invalid + dp[i - 1][p * j]) % MOD;
                        p++;
                    }
//                    为初始化添加增量
                    dp[i][j] = (sum - invalid + MOD) % MOD;
                }
            }
            int sum = 0;
            for (int i = 1; i <= k; i++) {
                sum = (sum + dp[n][i]) % MOD;
            }
            System.out.println(sum);
        }
    }
}
