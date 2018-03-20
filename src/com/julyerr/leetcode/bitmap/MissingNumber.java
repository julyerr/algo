package com.julyerr.leetcode.bitmap;

public class MissingNumber {
    public int missingNumber(int[] nums) {
//        check validation
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int ret = nums.length;
        for (int i = 0; i < nums.length; i++) {
            ret ^= nums[i] ^ i;
        }
        return ret;
    }
}
