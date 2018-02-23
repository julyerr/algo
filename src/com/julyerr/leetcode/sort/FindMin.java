package com.julyerr.leetcode.sort;

public class FindMin {
    public int findMin(int[] nums) {
//        should not happend
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] < nums[high]) {
//                如果只有两个元素，high = mid - 1, mid = 0 ,发生越界访问
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = high - 1;
            }
        }
        return nums[low];
    }
}
