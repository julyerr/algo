package com.julyerr.leetcode.array;

public class JumpGame {
    public boolean canJump(int[] nums) {
//        check validation
        if (nums == null || nums.length == 0) {
            return false;
        }
        int maxStep = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
//            选择最大的step
            maxStep = Math.max(maxStep, nums[i]  + i);
            if (maxStep >= nums.length - 1) {
                return true;
            }
//            不能前进
            if (nums[i] ==0 && maxStep == i) {
                return false;
            }
        }
        return false;
    }
}
