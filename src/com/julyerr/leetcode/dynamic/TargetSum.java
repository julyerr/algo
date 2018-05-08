package com.julyerr.leetcode.dynamic;

/*
 * 参考大神的解题思路：http://bgmeow.xyz/2017/01/29/LeetCode-494/
 * 采用动态规划的方式:
 *   dp[i]表示结果为i的方法种数
 *   sum(p)-sum(n)=s;
 *   sum(p)+sum(n)+sum(p)-sum(n) = s+sum(p)+sum(n);
 *   s+sum(nums) = 2*sum(p);
 *   sum(p) = (s+sum(nums))/2,转换成在nums中求解和为(s+sum(nums))/2的个数，背包问题
 * */
public class TargetSum {
    public int findTargetSumWaysDP(int[] nums, int S) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
        }
        if (s < S || (S + s) % 2 == 1) {
            return 0;
        }
        int tmp = (S + s) >> 1;
        return dps(nums, tmp);
    }

    private int dps(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = s; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[s];
    }

    int count = 0;

    //    直观的dfs解题思路,时间复杂度是幂次方
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        dfs(0, 0, nums, S);
        return count;
    }

    private void dfs(int curS, int cur, int[] nums, int S) {
        if (cur == nums.length) {
            if (curS == S) {
                count++;
            }
            return;
        }
        dfs(curS + nums[cur], cur + 1, nums, S);
        dfs(curS - nums[cur], cur + 1, nums, S);
    }
}
