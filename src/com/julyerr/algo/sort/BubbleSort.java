package com.julyerr.algo.sort;

import com.julyerr.algo.utils.Utils;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{20,40,30,10,60,50};
//        int[] nums = new int[]{1, 1, 1, 3, 3, 3, 2, 2, 2};
        BubbleSort.bubbleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int length = nums.length;
        for (int i = length - 1; i > 0; i--) {
            boolean sortEd = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    Utils.swap(nums, j, j + 1);
                    sortEd = false;
                }
            }
            if (sortEd) {
                return;
            }
        }
    }
}
