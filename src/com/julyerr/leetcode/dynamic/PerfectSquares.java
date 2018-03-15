package com.julyerr.leetcode.dynamic;

import java.util.Arrays;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
 * which sum to n.
 * <p>
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */

/**
 * 比较巧妙，很难想到
 */
public class PerfectSquares {
    public int numSquares(int n) {
        if(n < 2){
            return n;
        }
        int[] dp = new int[n+1];
//        初始化为最大值
        Arrays.fill(dp,Integer.MAX_VALUE);
//        将所有的平方数均设置为1
        for (int i = 1; i*i <=n; i++) {
            dp[i*i] = 1;
        }
        for (int i = 1; i <=n; i++) {
//            迭代进行比较，类似素数筛选的过程
            for (int j = 1; i+j*j <=n ; j++) {
                dp[i+j*j] = Math.min(dp[i]+1,dp[i+j*j]);
            }
        }

        return dp[n];
    }
}
