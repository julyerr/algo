package com.julyerr.targetOffer.sort;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 */

/**
 * 开始想着暴力直接求解，结果发现还有归并排序的方式（虽然时间复杂度O(nlog(n))
 * 如果面试的时候实在没有思路再暴力，不然暴力求解的题目做了通常也不能给自己加分
 */
public class InverseNumber {
    public int InversePairs(int[] array) {
//        check validation
        if (array == null || array.length == 0 || array.length == 1) {
            return 0;
        }
        return mergeCore(array, 0, array.length - 1);
    }

    private int mergeCore(int[] data, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) >> 1;
        int left = mergeCore(data, start, mid);
        int right = mergeCore(data, mid + 1, end);
        int count = merge(data, start, mid, end);
        return (left + right + count) % 1000000007;
    }

    private int merge(int[] data, int start, int mid, int end) {
        int ret = 0;
        int[] tmp = new int[end - start + 1];
        int index = 0;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            if (data[left] < data[right]) {
                tmp[index++] = data[left++];
//                不存在相等的情况
            } else {
                tmp[index++] = data[right++];
//                很难想到这一步
                ret += mid + 1 - left;
                if (ret > 1000000007) {
                    ret %= 1000000007;
                }
            }
        }
        while (left <= mid) {
            tmp[index++] = data[left++];
        }
        while (right <= end) {
            tmp[index++] = data[right++];
        }
        for (int i = 0; i < tmp.length; i++) {
            data[i + start] = tmp[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        InverseNumber inverseNumber = new InverseNumber();
//        int[] nums = new int[]{7, 5, 6, 4};
        int[] nums = new int[]{5, 6, 7, 8, 1, 2, 3, 4};
        System.out.println(inverseNumber.InversePairs(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
