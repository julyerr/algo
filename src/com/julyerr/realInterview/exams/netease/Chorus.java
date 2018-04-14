package com.julyerr.realInterview.exams.netease;

import java.util.Scanner;

/*
 * 参考大神的解题思路：https://www.nowcoder.com/questionTerminal/fddf64d5757e41ec93f3ef0c0a10b891
 * 使用动态规划，dp[i][j]表示最近一次第一个人唱的是i，第二个人唱的是j
 * 不妨设置i>j:
 * 当j = i-1，说明发生了交换的情况，dp[i][j] = min(dp[i-1][k]，dp[i-1][k]+abs(nums[i]-nums[k])), 0<=k<i-1;
 * 当j<i-1，说明唱i字符的时候没有发生交换的情况,dp[i][j] = dp[i-1][j]+abs(nums[i]-nums[i-1])
 * */
public class Chorus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int[] acc = new int[n];
            int[][] dp = new int[n][n];
            for (int i = 1; i < n; i++) {
                acc[i] = acc[i - 1] + Math.abs(nums[i] - nums[i - 1]);
//                初始化dp[i][i-1]
                dp[i][i - 1] = acc[i - 1];
                for (int j = 0; j < i - 1; j++) {
//                    第一种情况
                    dp[i][j] = dp[i - 1][j] + acc[i] - acc[i - 1];
//                    第二种情况
                    dp[i][i - 1] = Math.min(dp[i][i - 1], dp[i - 1][j] + Math.abs(nums[i] - nums[j]));
                }
            }
//            统计最小值
            int min = dp[n - 1][0];
            for (int i = 1; i < n - 1; i++) {
                min = Math.min(min, dp[n - 1][i]);
            }
            System.out.println(min);
        }
    }
}
