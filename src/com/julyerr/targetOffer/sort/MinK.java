package com.julyerr.targetOffer.sort;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */

/*
 * 使用快排实现，面试的时候手写快排还是很有可能的
 * */
public class MinK {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> rt = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || k > input.length) {
            return rt;
        }
        quickSort(input, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            rt.add(input[i]);
        }
        return rt;
    }

    private void quickSort(int[] input, int start, int end) {
        if (start >= end) {
            return;
        }
        int first = input[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (right > left && input[right] >= first) {
                right--;
            }
            if (right > left) {
                input[left++] = input[right];
            }
            while (left < right && input[left] <= first) {
                left++;
            }
            if (left < right) {
                input[right--] = input[left];
            }
        }
        input[left] = first;

        quickSort(input, start, left - 1);
        quickSort(input, left + 1, end);
    }

    public static void main(String[] args) {
        MinK minK = new MinK();
//        int[] nums = new int[]{4,5,1,6,2,7,3,8};
//        int k = 4;
//        int k = 9;

        int[] nums = new int[]{5, 5, 5, 3, 3, 1};
        int k = 1;
//        int k = 0;
        for (Integer i :
                minK.GetLeastNumbers_Solution(nums, k)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
