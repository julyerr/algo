package com.julyerr.targetOffer.bitmap;

/**
 * 一个整数数组里除了两个数字出现一次，其他数字都出现两次。
 * 请找出这两个数字。要求时间复杂度为o(n)，空间复杂度为o(1)。
 */

/**
 * blog: https://www.jianshu.com/p/1a9997924cc6
 * 算法比较巧妙，以前解决过类似求数组中出现仅一次的单个元素
 * 需要将整个数组划分为两部分，每一部分利用出现一个的单个元素的解法
 * 划分依据：
 * n计算所有的^的结果，判断某位是否为1进行划分
 */
public class TwoOfOnce {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
//        should not happend
        if (array == null || array.length == 0 || array.length < 1) {
            return;
        }
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            n ^= array[i];
        }
        int bit = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & bit) != 0) {
                break;
            }
            bit <<= 1;
        }
//        divide the arrays into two part
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & bit) != 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    public static void main(String[] args) {
        TwoOfOnce twoOfOnce = new TwoOfOnce();
        int[] nums = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        twoOfOnce.FindNumsAppearOnce(nums, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
