package com.julyerr.algo.sort;

/**
 * 时间复杂度O(log(n)) 空间复杂度O(n) 稳定性排序
 */

/**
 * 有时候在编码之前，很难够所有的情况弄清楚，可以先编码实现自己的思路，然后结合实例验证边缘条件进行修改即可
 * 有解决的思路 -> 实现思路 -> 对思路进行调整，正确解答
 */

public class MergeSort {
    public static void main(String[] args) {
//        int[] nums = new int[]{3, 2, 5, 4, 1};
//        int[] nums = new int[]{1};
        int[] nums = new int[]{1, 2, 2, 5, 5, 5, 3, 3};
//        mergeSort(nums);
        MergeSort.mergeSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        mergeCore(nums, 0, nums.length - 1);
    }

    //    数组分裂
    private static void mergeCore(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeCore(nums, left, mid);
        mergeCore(nums, mid + 1, right);
//        数组合并
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int begin, int mid, int end) {
        int[] ret = new int[end - begin + 1];
        int index = 0;
        int left = begin;
        int right = mid+1;
        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                ret[index++] = nums[left++];
            } else {
                ret[index++] = nums[right++];
            }
        }
        while (left <= mid) {
            ret[index++] = nums[left++];
        }
        while (right <= end) {
            ret[index++] = nums[right++];
        }
        for (int i = begin; i <= end; i++) {
            nums[i] = ret[i - begin];
        }
    }
}
