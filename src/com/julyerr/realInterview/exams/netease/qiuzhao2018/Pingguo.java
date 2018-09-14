package com.julyerr.realInterview.exams.netease.qiuzhao2018;

import java.util.Scanner;

/*
5
2 7 3 4 9
3
11 1 25
//参考思路： https://blog.csdn.net/navyifanr/article/details/20655881
* */
public class Pingguo {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] segs = new int[n];
//        int delta = 0;
//        for (int i = 0; i < n; i++) {
//            delta += scanner.nextInt();
//            segs[i] = delta;
//        }
//        int times = scanner.nextInt();
//        for (int i = 0; i < times; i++) {
//            int k = scanner.nextInt();
//            System.out.println(1 + find(segs, k));
//        }
//    }

    private static int find(int[] segs, int val) {
        int left = 0;
        int right = segs.length - 1;
        int mid = (left + right + 1) >> 1;
        while (left < right) {
            if (segs[mid] == val) {
                return mid;
            } else if (segs[mid] > val) {
                right = mid - 1;
            } else {
                left = mid;
            }
            mid = (left + right + 1) >> 1;
        }
        if (segs[left] < val) {
            return left + 1;
        }
        return left;
    }

    //    比较典型的二分查找的思路
    private static int binarySearch(int[] nums, int n) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == n) {
                return mid;
            } else if (nums[mid] > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
        //        return -1;
    }

    public static void main(String[] args){
//        int[] nums = new int[]{1,3};
//        int[] nums = new int[]{1,3,4};
//        int[] nums = new int[]{1,3,6};
        int[] nums = new int[]{1};
        System.out.println(binarySearch(nums,1));
    }
}
