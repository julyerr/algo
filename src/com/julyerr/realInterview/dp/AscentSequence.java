package com.julyerr.realInterview.dp;

/*
 * 参考大神的解题思路：https://blog.csdn.net/silangquan/article/details/8230750
 * */
public class AscentSequence {
    //    使用动态规划，dp[i+1]表示表示包含A[i]的最长递增子序列，由于可能出现多个，因此需要迭代判断
    public int findLongest(int[] A, int n) {
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i + 1] = 1;
            for (int j = 0; j < i; j++) {
//                转移状态关系
                if (A[i] > A[j] && dp[j + 1] + 1 > dp[i + 1]) {
                    dp[i + 1] = dp[j + 1] + 1;
                }
            }
            max = Math.max(max, dp[i + 1]);
        }
        return max;
    }
}
