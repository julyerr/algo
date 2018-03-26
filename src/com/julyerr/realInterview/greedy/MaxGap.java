package com.julyerr.realInterview.greedy;

/*
 * 直接使用暴力求解，时间复杂度为O(n^2)；
 * 参考大神的解题思路，先确定最大值，然后最小值只能在两端取到（因为不断扩展的时候，只会增大不可能减小）
 * */
public class MaxGap {
//    public int findMaxGap(int[] A, int n) {
//        if (n < 3) {
//            return Math.abs(A[0] - A[A.length - 1]);
//        }
////        初始化两部分最大值
//        int max1 = A[0];
//        int max2 = A[1];
//        for (int i = 2; i < n; i++) {
//            max2 = Math.max(max2, A[i]);
//        }
//
//        int maxGap = Math.abs(max1 - max2);
////        针对不同的切分方法，更新元素的值
//        for (int i = 1; i < n - 1; i++) {
//            if (A[i] == max2) {
//                max2 = A[i + 1];
//                for (int j = i + 2; j < n; j++) {
//                    max2 = Math.max(max2, A[j]);
//                }
//            }
//            if (max1 < A[i]) {
//                max1 = A[i];
//            }
//            maxGap = Math.max(maxGap, Math.abs(max1 - max2));
//        }
//        return maxGap;
//    }

    public int findMaxGap(int[] A, int n) {
        int max = A[0];
//        找到最大值
        for (int i = 1; i < n; i++) {
            max = Math.max(max, A[i]);
        }
//        确定最小值
        int min = A[0] > A[n - 1] ? A[n - 1] : A[0];
        return max - min;
    }
}
