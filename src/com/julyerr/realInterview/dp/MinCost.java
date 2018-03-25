package com.julyerr.realInterview.dp;

/*
 * 参考大神的解题思路：https://www.nowcoder.com/questionTerminal/04f1731f32e246b4a19688972d5e2600
 * */
public class MinCost {
    //    dp[i][j] 表示将长为i的字符串A转换成长为j的字符串B需要的代价
    public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
//        初始化的时候需要特殊处理
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
//            不断删除
            dp[i][0] = dp[i - 1][0] + c1;
        }

        for (int i = 1; i <= m; i++) {
//            不断插入
            dp[0][i] = dp[0][i - 1] + c0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    /*
                     * 调整的时候有三种情况，
                     * 修改：dp[i-1][j-1]基础上修改
                     * 插入：dp[i][j-1]基础上往m中插入一个字符
                     * 删除：dp[i-1][j]，i-1长度的n已经转变成j长度的m，那么只需要删除一个字符就可以
                     * */
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + c0, Math.min(dp[i][j - 1] + c1, dp[i - 1][j - 1] + c2));
                }
            }
        }
        return dp[n][m];
    }
}
