package com.julyerr.leetcode.array;

public class MinSizeSubArray {
    public int minSubArrayLen(int s, int[] nums) {
//        check validation
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;
//        end 就是 i
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= s) {
                while (sum - nums[start] >= s) {
                    sum -= nums[start++];
                }
                min = Math.min(min, i + 1 - start);
            }
        }
        if (min > nums.length) {
            return 0;
        }
        return min;
    }
}
