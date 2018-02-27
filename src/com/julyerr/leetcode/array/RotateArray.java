package com.julyerr.leetcode.array;

public class RotateArray {
    public void rotate(int[] nums, int k) {
//    check validation
        if (nums == null || nums.length < 2 || k < 1) {
            return;
        }
        int length = nums.length;
//        提高反转效率
        k = k % length;

        rotate(nums, 0, length - 1 - k);
        rotate(nums, length - k, length - 1);
        rotate(nums, 0, length - 1);
    }

    private static void rotate(int[] nums, int start, int end) {
        while (start < end) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }
}
