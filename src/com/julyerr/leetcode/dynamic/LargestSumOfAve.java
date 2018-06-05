package com.julyerr.leetcode.dynamic;

/*
使用动态规划的方式进行求解：
    参考解题思路：https://blog.csdn.net/magicbean2/article/details/79893634
dp[i][k] 表示将i+1个数，分成k个小组的最大的平均数之和；
k = 1:
	dp[i][k] = ave(A[0],A[1]...,A[n-1])
k > 1:
	dp[i][k] = Math.max(dp[i][k],dp[j][k-1]+ave(A[j+1],...,A[n-1])), k-1<=j<=i
*/

public class LargestSumOfAve {
    public class Solution {
        public double largestSumOfAverages(int[] A, int K) {
            if (A == null || A.length == 0 || K > A.length) {
                return 0;
            }
            int len = A.length;
            int[] sum = new int[len];
            sum[0] = A[0];
            for (int i = 1; i < len; i++) {
                sum[i] = sum[i - 1] + A[i];
            }
            double[][] dp = new double[len][K + 1];
            for (int k = 1; k <= K; k++) {
                for (int i = 0; i < len; i++) {
                    if (k == 1) {
                        dp[i][k] = 1.0 * sum[i] / (i + 1);
                    } else if (k > i + 1) {
                        continue;
                    } else {
                        for (int j = k - 1; j <= i; j++) {
                            double ave = 1.0 * (sum[i] - sum[j - 1]) / (i - j + 1);
                            dp[i][k] = Math.max(dp[i][k], dp[j - 1][k - 1] + ave);
                        }
                    }
                }
            }
            return dp[len - 1][K];
        }
    }
}
