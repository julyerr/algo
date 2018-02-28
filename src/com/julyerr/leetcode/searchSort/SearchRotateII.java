package com.julyerr.leetcode.searchSort;

public class SearchRotateII {
    public boolean search(int[] nums, int target) {
//        check validation
        if (nums == null || nums.length == 0) {
            return false;
        }

//        二分法查找
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return true;
//                mid ~ right 直接有序
            } else if (nums[mid] < nums[right]) {
//                元素处于 mid ~ right之间
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
//                left ~ mid 有序
            } else if (nums[mid] > nums[right]) {
//                元素处于 left ~ mid之间
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchRotateII searchRotateII = new SearchRotateII();
        int[] nums = new int[]{3, 1, 1};
        int target = 3;
        System.out.println(searchRotateII.search(nums, target));
    }
}
