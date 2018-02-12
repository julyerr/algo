package com.julyerr.algo.sort;

import com.julyerr.algo.utils.Utils;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{20, 40, 30, 10, 60, 50};
//        int[] nums = new int[]{1, 1, 1, 3, 3, 3, 2, 2, 2};
        SelectionSort.selectSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void selectSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            if (min != i) {
                Utils.swap(nums, i, min);
            }
        }
    }
}
