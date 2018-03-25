package com.julyerr.realInterview.dp;

public class WildMatch {
//    直接调用库函数进行判断
    //    public boolean chkWildMatch(String A, int lena, String B, int lenb) {
//        return A.matches(B);
//    }

    //    使用动态规划dp[i][j] 表示1-i 的字符串被1-j的字符串匹配
    public boolean chkWildMatch(String A, int lena, String B, int lenb) {
        boolean[][] dp = new boolean[lena + 1][lenb + 1];
        dp[0][0] = true;
        for (int i = 1; i <= lena; i++) {
            for (int j = 1; j <= lenb; j++) {
                char c = B.charAt(j - 1);
                if (c == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (c == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && A.charAt(i - 1) == c;
                }
            }
        }
        return dp[lena][lenb];
    }
}
