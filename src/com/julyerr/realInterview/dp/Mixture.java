package com.julyerr.realInterview.dp;

/*
 * 参考大神的解题思路：https://www.nowcoder.com/questionTerminal/0ed4ac79ab264c6f9b58fc9ba6188793
 * */
public class Mixture {
    //使用动态规划，dp[i][j] 表示长为i的字符串A和长度j的字符串B是否按照原来字符的顺序排列组成长为i+j-1字符串C
    public boolean chkMixture(String A, int n, String B, int m, String C, int v) {
        boolean[][] dp = new boolean[n + 1][m + 1];
//        初始化0行和0列
        for (int i = 1; i <= m; i++) {
            if (B.charAt(i - 1) == C.charAt(i - 1)) {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (A.charAt(i - 1) == C.charAt(i - 1)) {
                dp[i][0] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!dp[i][j]) {
                    dp[i][j] = dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1) ||
                            dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1);
                }
            }
        }
        return dp[n][m];
    }
}
