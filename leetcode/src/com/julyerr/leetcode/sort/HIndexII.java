package com.julyerr.leetcode.sort;

/**
 * Follow up for H-Index: What if the citations array is sorted in ascending order?
 * Could you optimize your algorithm?
 */

/**
 * using binary search algo
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int low = 0, high = citations.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (citations[mid] == n - mid) {
                return n - mid;
            } else if (citations[mid] < n - mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return n - low;
    }
}

