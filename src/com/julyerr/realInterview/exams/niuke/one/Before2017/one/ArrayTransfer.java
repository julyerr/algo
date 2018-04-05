package com.julyerr.realInterview.exams.niuke.one.Before2017.one;

import java.util.Scanner;

/*
 * 如果所有的数都能通过转换变成同一个数，那么原数组中最大数一定是其他数的2^n次倍
 * */
public class ArrayTransfer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
                max = Math.max(max, nums[i]);
            }
            boolean flag = true;

            for (int i = 0; i < n; i++) {
                int tmp = max / nums[i];
//                判断是否为2^n次倍
                if ((tmp & (tmp - 1)) != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
