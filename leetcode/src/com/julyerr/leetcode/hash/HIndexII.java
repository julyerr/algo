package com.julyerr.leetcode.hash;

/**
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 * <p>
 * Hint:
 * <p>
 * Expected runtime complexity is in O(log n) and the input is sorted.
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        /**
         * 边界条件最容易出现错误
         */
//        //        check validation
//        if (citations == null || citations.length == 0 || citations[citations.length-1] == 0) {
//            return 0;
//        }
//        int length = citations.length;
//        int left = 0;
//        int right = length - 1;
//        int mid = 0;
//        while (left < right) {
//            mid = (left + right) / 2;
//            if (citations[mid] < length - mid) {
//                left = mid + 1;
//            } else if (citations[mid] > length - mid) {
//                right = mid - 1;
//            } else {
//                return citations[mid];
//            }
//        }
//        return length - mid;


        /**
         * 边界条件，如果包含最后一个元素的话通常需要设置left<=right , 决定退出的条件不妨设置极端情况看看时候符合题意
         */
        int n = citations.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (citations[mid] == n - mid) {
                return n - mid;
            } else if (citations[mid] < n - mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
//        决定退出的条件不妨设置极端情况看看时候符合题意
        return n - low;
    }

    public static void main(String[] args) {
        int[] citations = new int[]{0, 1};
//        int[] citations = new int[]{1,4,7,9};
        HIndexII hIndexI = new HIndexII();
        System.out.println(hIndexI.hIndex(citations));
    }
}
