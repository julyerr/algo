package com.julyerr.niuke;

import java.util.Scanner;

/*
* 题目描述
一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3
输入描述:
输入为两行。 第一行一个整数n(1 <= n <= 100000)，表示一共有n个元素 第二行为n个数，即每个元素,每个整数都在32位int范围内。以空格分隔。
输出描述:
所有连续子数组中和最大的值。
示例1
输入

3 -1 2 1
输出

3
* */
public class MaxSumSubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            nums[0] = scanner.nextInt();
            int cur = nums[0];
            int max = nums[0];
            for (int i = 1; i < n; i++) {
                nums[i] = scanner.nextInt();
                cur = (cur + nums[i]) > nums[i] ? (cur + nums[i]) : nums[i];
                max = Math.max(max, cur);
            }
            System.out.println(max);
        }
    }
}
