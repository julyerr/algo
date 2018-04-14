package com.julyerr.realInterview.exams.netease.qiuzhao2017;


import java.util.Arrays;
import java.util.Scanner;

/*
 * 参考大神的解题思路：https://www.nowcoder.com/questionTerminal/4284c8f466814870bae7799a07d49ec8
 * 使用动态规划，dp[i]表示到达i的步数
 * dp[i+j] = min(dp[i+j],dp[i]+j),j 为i的约数
 * */
public class BengShiban {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int[] dp = new int[M + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[N] = 0;
            for (int i = N; i <= M; i++) {
//                该位置可达
                if (dp[i] != Integer.MAX_VALUE) {
                    for (int j = 2; j * j <= i; j++) {
//                        有公共的因子
                        if (i % j == 0) {
//                            两种情况都可能进行更新
                            if (i + j <= M) {
                                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                            }
                            if (i + i / j <= M) {
                                dp[i + i / j] = Math.min(dp[i + i / j], dp[i] + 1);
                            }
                        }
                    }
                }
            }
            System.out.println(dp[M] == Integer.MAX_VALUE ? -1 : dp[M]);
        }
    }
}
