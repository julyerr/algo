package com.julyerr.algo.sort;


public class InsertSort {
    public static void main(String[] args) {
//        int[] nums = new int[]{20, 40, 30, 10, 60, 50};
        int[] nums = new int[]{1, 1, 1, 3, 3, 3, 2, 2, 2};
        InsertSort.insertSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void insertSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int tmp = nums[i];
            int j = i;
            for (; j > 0 && tmp < nums[j - 1]; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = tmp;
        }
    }
}
