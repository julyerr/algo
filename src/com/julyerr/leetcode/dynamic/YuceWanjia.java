package com.julyerr.leetcode.dynamic;

/*
 * 参考大神的解题思路：https://blog.csdn.net/cloudox_/article/details/64122204
 *
 * 每次取一个数相当于玩家增加分数，另一方取一个数相当于减去一个数，最后判断结果是否大于0即可
 * */
public class YuceWanjia {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length < 3) {
            return true;
        }
        return help(nums, 0, nums.length - 1) >= 0;
    }

    private int help(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        return Math.max(nums[left] - help(nums, left + 1, right), nums[right] - help(nums, left, right - 1));
    }
}