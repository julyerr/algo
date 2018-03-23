package com.julyerr.leetcode.bitmap;

public class SingleNumIII {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] ret = new int[2];
        int n = 0;
//        先计算出各个数的^的结果
        for (int i = 0; i < nums.length; i++) {
            n ^= nums[i];
        }
//        确定最后一位1的数，用以划分数组
        n = n & (~(n - 1));
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & n) == 0) {
                ret[0] ^= nums[i];
            } else {
                ret[1] ^= nums[i];
            }
        }
        return ret;
    }
}
