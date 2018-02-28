package com.julyerr.leetcode.searchSort;

public class FindPeakElem {
    public int findPeakElement(int[] nums) {
//        check validation
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
