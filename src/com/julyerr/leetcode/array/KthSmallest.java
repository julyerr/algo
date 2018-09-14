package com.julyerr.leetcode.array;

import java.util.Arrays;

public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] nums = new int[n * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[index++] = matrix[i][j];
            }
        }
        Arrays.sort(nums);
        int ret = 0;
        index = 0;
        while (k-- > 0) {
            ret = nums[index++];
//            if (index < n * n - 1 && nums[index] == nums[index + 1]) {
//                index++;
//            }
        }
        return ret;
    }
}
