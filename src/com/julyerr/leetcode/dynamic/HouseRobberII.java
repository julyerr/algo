package com.julyerr.leetcode.dynamic;

import java.util.Arrays;
import java.util.Collections;

/**
 * After robbing those houses on that street, the thief has found himself a new place for his thievery
 * so that he will not get too much attention.
 * This time, all houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one.
 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */

//典型的动态规划的问题，每一次计算的结果都是依赖于前面保留下来的值
//    开始没有理解题目意思，关键是起点已经确定了，只是选择的方向可以不同，比较两种选择方式的大小即可
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
//        划分成两段分别进行最大值计算
        return Math.max(robCore(nums, 0, nums.length - 2), robCore(nums, 1, nums.length - 1));
    }

    private int robCore(int[] nums, int start, int end) {
        if (start >= end) {
            return nums[start];
        }
        if (end == start + 1) {
            return Math.max(nums[start], nums[end]);
        }
//        使用三个变量记录最大值的情况
        int step0 = nums[start];
        int step1 = Math.max(nums[start], nums[start + 1]);
        int step2 = 0;
        for (int i = start + 2; i <= end; i++) {
            step2 = Math.max(step0 + nums[i], step1);
            step0 = step1;
            step1 = step2;
        }
        return step2;
    }

    public static void main(String[] args) {
        HouseRobberII houseRobberII = new HouseRobberII();
        int[] nums = new int[]{1, 2, 1, 1};
        System.out.println(houseRobberII.rob(nums));
    }
}
