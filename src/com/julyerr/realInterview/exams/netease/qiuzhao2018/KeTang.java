package com.julyerr.realInterview.exams.netease.qiuzhao2018;

import java.util.Scanner;

/*
6 3
1 3 5 2 5 4
1 1 0 1 0 0
* */
public class KeTang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        int[] wait = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            wait[i] = scanner.nextInt();
            if (wait[i] != 0) {
                sum += nums[i];
            }
        }
        int max = 0;
        for (int i = 0; i < k; i++) {
            if (wait[i] == 0) {
                max += nums[i];
            }
        }
        int pre = max;
        for (int i = k; i < n; i++) {
            if (wait[i] == 0) {
                pre += nums[i];
            }
            if (wait[i - k] == 0) {
                pre -= nums[i - k];
            }
            max = Math.max(max, pre);
        }
        System.out.println(sum + max);
    }
}
