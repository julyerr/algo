package com.julyerr.targetOffer.sort;

/**
 * 时间复杂度O(log(n)) 空间复杂度O(n) 稳定性排序
 */

/**
 * 有时候在编码之前，很难够所有的情况弄清楚，可以先编码实现自己的思路，然后结合实例验证边缘条件进行修改即可
 * 有解决的思路 -> 实现思路 -> 对思路进行调整，正确解答
 */

public class MergeSort {
    public static void mergeSort(int[] data) {
        if (data == null || data.length == 0) {
            return;
        }
        mergeCore(data, 0, data.length - 1);
    }

    public static void mergeCore(int[] data, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = (begin + end) / 2;
        mergeCore(data, begin, mid);
        mergeCore(data, mid + 1, end);
        merge(data, begin, mid, end);
    }

    public static void merge(int[] data, int begin, int mid, int end) {
        int[] ret = new int[end - begin + 1];
        int left = begin;
        int right = mid + 1;
        int index = 0;
        while (left <= mid && right <= end) {
            if (data[left] < data[right]) {
                ret[index++] = data[left++];
            } else {
                ret[index++] = data[right++];
            }
        }
        while (left <= mid) {
            ret[index++] = data[left++];
        }
        while (right <= end) {
            ret[index++] = data[right++];
        }
        for (int i = 0; i < ret.length; i++) {
            data[begin + i] = ret[i];
        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3,2,5,4,1};
//        int[] nums = new int[]{1};
        int[] nums = new int[]{1, 2, 2, 5, 5, 5, 3, 3};
        mergeSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
