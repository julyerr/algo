package com.julyerr.leetcode.dynamic;

public class MaximalSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < length; i++) {
//            dp[i]包含nums[i]的最大子串的和
            dp[i] = Math.max(dp[i - 1] + nums[i], dp[i]);
//            迭代更新max的值
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
