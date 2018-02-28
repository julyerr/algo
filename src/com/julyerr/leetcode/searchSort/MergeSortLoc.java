package com.julyerr.leetcode.searchSort;

public class MergeSortLoc {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        cursor
        int index = m + n - 1;
        m -= 1;
        n -= 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] <= nums2[n]) {
                nums1[index--] = nums2[n];
                n--;
            } else {
                nums1[index--] = nums1[m];
                m--;
            }
        }
        while (m >= 0) {
            nums1[index--] = nums1[m--];
        }
        while (n >= 0) {
            nums1[index--] = nums2[n--];
        }
    }
}
