package com.julyerr.leetcode.dynamic;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.

 */
public class HouseRobberI {
    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }else if (length == 1){
            return nums[0];
        }
        int step0,step1,step2;
        step0 = step2 = 0;
        step1 = nums[0];
        for (int i = 1; i < length; i++) {
            step2 = Math.max(step1,step0+nums[i]);
            step0 = step1;
            step1 = step2;
        }
        return step2;
    }
}
