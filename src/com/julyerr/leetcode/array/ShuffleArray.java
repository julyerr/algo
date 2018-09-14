package com.julyerr.leetcode.array;

import java.util.Random;

public class ShuffleArray {
    private int[] num;
    private int[] nums;
    Random random;

    public ShuffleArray(int[] nums) {
        num = new int[nums.length];
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            num[i] = nums[i];
        }
        random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = num[i];
        }
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int tmp = i + random.nextInt(n - i);
            int a = nums[tmp];
            nums[tmp] = nums[i];
            nums[i] = a;
        }
        return nums;
    }
}
