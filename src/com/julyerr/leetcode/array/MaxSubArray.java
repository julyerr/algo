package com.julyerr.leetcode.array;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
//        check validation,should not happen here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int curSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(curSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
