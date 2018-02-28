package com.julyerr.leetcode.searchSort;

public class SeachRange {
    public int[] searchRange(int[] nums, int target) {
//        check validation
        if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }

        int length = nums.length;

//        二分查找
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                int start, end;
                start = end = mid;
                while (start - 1 >= 0 && nums[start - 1] == target) {
                    start--;
                }
                while (end + 1 <= length - 1 && nums[end + 1] == target) {
                    end++;
                }
                return new int[]{start, end};
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
