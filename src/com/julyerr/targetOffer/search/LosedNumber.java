package com.julyerr.targetOffer.search;

/**
 * 一个长度为n的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0~n之内。
 * 在范围0~n内的n个数字有且只有一个数字不在该数组中，请找出。
 */

/**
 * 看到已经排序好的数组进行查找的，自然联想到二分法
 */
public class LosedNumber {
    public int losedNumber(int[] nums) {
//        线性的时间复杂度O(n)
//        if (nums == null || nums.length == 0) {
//            return -1;
//        }
//        int n = nums.length;
//        if (nums[0] != 0) {
//            return 0;
//        } else if (nums[n - 1] != n) {
//            return n;
//        }
//        for (int i = 1; i < n; i++) {
//            if (nums[i] - nums[i - 1] != 1) {
//                return nums[i] - 1;
//            }
//        }
////        should not happend here
//        return -1;

//        通过二分法，O(log(n))的时间复杂度
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        LosedNumber losedNumber = new LosedNumber();
//        int[] nums = new int[]{1,2,3,4};
//        int[] nums = new int[]{0,1,2,3};
//        int[] nums = new int[]{0, 2, 3, 4};
        int[] nums = new int[]{0};
        System.out.println(losedNumber.losedNumber(nums));
    }
}
