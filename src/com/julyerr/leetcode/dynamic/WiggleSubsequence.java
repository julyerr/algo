package com.julyerr.leetcode.dynamic;

import java.util.Arrays;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return 1;
        }
        boolean[] asc = new boolean[length];
        boolean[] desc = new boolean[length];
        Arrays.fill(asc, true);
        Arrays.fill(desc, true);
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (dp[i] + 1 > dp[j]) {
                    if (nums[i] > nums[j] && asc[i]) {
                        dp[j] = dp[i] + 1;
                        asc[j] = false;
                        desc[j] = true;
                    } else if (nums[i] < nums[j] && desc[i]) {
                        dp[j] = dp[i] + 1;
                        asc[j] = true;
                        desc[j] = false;
                    }
                }
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }
}
