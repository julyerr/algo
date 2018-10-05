package com.julyerr.leetcode.array;

/*
 * 解题思路参考：https://blog.csdn.net/ojshilu/article/details/19570695
 * 左右最大高度是否大于当前高度
 * */
public class TrappingWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            if (height[i] > left[i - 1]) {
                left[i] = height[i];
            } else {
                left[i] = left[i - 1];
            }
        }
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (height[i] > right[i + 1]) {
                right[i] = height[i];
            } else {
                right[i] = right[i + 1];
            }
        }

        int water = 0;
        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(left[i - 1], right[i + 1]);
            if (min > height[i]) {
                water += min - height[i];
            }
        }
        return water;
    }
}
