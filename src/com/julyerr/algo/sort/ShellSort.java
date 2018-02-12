package com.julyerr.algo.sort;

public class ShellSort {
    public static void main(String[] args) {
        int[] nums = new int[]{20, 40, 30, 10, 60, 50};
//        int[] nums = new int[]{1, 1, 1, 3, 3, 3, 2, 2, 2};
        ShellSort.shellSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void shellSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int length = nums.length;
        int step = 1;
        while (step < length / 3) {
            step *= 3;
        }
//        递归减小step
        while (step >= 1) {
            for (int i = 0; i < step; i++) {
//                针对每个间隔step的元素进行插入排序
                for (int j = i + step; j < length; j += step) {
                    int tmp = nums[j];
                    int k = j;
                    for (; k - step >= 0 && tmp < nums[k - step]; k -= step) {
                        nums[k] = nums[k - step];
                    }
                    nums[k] = tmp;
                }
            }

            step /= 3;
        }
    }
}
