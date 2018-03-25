package com.julyerr.realInterview.array;

import java.util.Arrays;

/*
 * 有大神提供了O(n)时间复杂度的方法，但是看不懂，也想不到哈;
 * 下面这种方式先将数组排序好，然后确定需要排序的范围
 * */
public class MinSubArray {
    public int findShortest(int[] A, int n) {
        if (n < 2) {
            return 0;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = A[i];
        }
        Arrays.sort(nums);
        int left = 0;
        int right = n - 1;
        while (left <= right && A[left] == nums[left]) {
            left++;
        }
        while (right >= left && A[right] == nums[right]) {
            right--;
        }
        return right - left + 1;
    }
}
