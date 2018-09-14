package com.julyerr.leetcode.array;

class NumArray {
    int[] sum;
    int[] array;

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        array = nums;
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] += sum[i] + nums[i];
        }
    }

    public void update(int i, int val) {
        int diff = val - array[i];
//        更新的数据需要保存下来
        array[i] = val;
        for (int j = i + 1; j <= array.length; j++) {
            sum[j] += diff;
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
