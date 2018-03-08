package com.julyerr.leetcode.searchSort;

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

        int length = citations.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
//            即使数组中出现重复的现象，也可以直接返回，因为下一次迭代，nums[i]--,但是hIndex++
            if (citations[mid] == length - mid) {
                return length - mid;
            } else if (citations[mid] > length - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return length - left;
    }
}

