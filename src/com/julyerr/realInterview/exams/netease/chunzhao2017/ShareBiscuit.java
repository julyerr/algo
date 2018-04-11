package com.julyerr.realInterview.exams.netease.chunzhao2017;

import java.util.Scanner;

/*
 * 参考大神的解题思路：
 *
 * https://www.nowcoder.com/questionTerminal/44d0ee89b51b4725b403d1df2381d2b2
 * 显然此题直接暴力会超时，10^18中可能情况，考虑使用动态规划
 * dp[i][j]表示前i个字符串对应整数mod n之后余数为j的情况数
 * 如果当下字符为X，则可以遍历0-9重新进行计算；
 * 否则可以具体计算出dp值
 * */
public class ShareBiscuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            int n = scanner.nextInt();
            int len = line.length();
            long[][] dp = new long[len + 1][n];
            dp[0][0] = 1;
            for (int i = 1; i <= len; i++) {
                for (int j = 0; j < n; j++) {
                    char c = line.charAt(i - 1);
                    if (c == 'X') {
//                        0-9进行遍历
                        for (int k = 0; k < 10; k++) {
                            dp[i][(j * 10 + k) % n] += dp[i - 1][j];
                        }
                    } else {
//                        直接计算
                        dp[i][(j * 10 + c - '0') % n] += dp[i - 1][j];
                    }
                }
            }
            System.out.println(dp[len][0]);
        }
    }
}
