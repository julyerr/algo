package com.julyerr.leetcode.searchSort;

public class SortColor {
    public void sortColors(int[] nums) {
//        check validation
        if (nums == null || nums.length == 0) {
            return;
        }

        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        while (cur <= right) {
            if (nums[cur] == 2) {
                swap(nums, cur, right--);
            } else {
                if (nums[cur] == 0) {
                    swap(nums, cur, left++);
                }
                cur++;
            }
        }
    }

    private static void swap(int[] nums, int m, int n) {
        int t = nums[m];
        nums[m] = nums[n];
        nums[n] = t;
    }
}
