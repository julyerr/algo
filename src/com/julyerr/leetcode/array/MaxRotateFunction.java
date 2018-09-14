package com.julyerr.leetcode.array;

import java.util.Scanner;

public class MaxRotateFunction {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length < 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int start = 0;
        int n = A.length;
        while (start < n) {
            int tmp = 0;
            int index = start;
            for (int i = 0; i < n; i++) {
                tmp += A[i] * index;
                if (++index >= n) {
                    index = 0;
                }
            }
            max = Math.max(max, tmp);
            start++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 6};
        System.out.println(new MaxRotateFunction().maxRotateFunction(nums));
    }
}
