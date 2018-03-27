package com.julyerr.realInterview.exams.niuke.one;

import java.util.Scanner;

public class Permutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int times = 0;
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] == i + 1) {
                    int tmp = nums[i + 1];
                    nums[i + 1] = nums[i];
                    nums[i] = tmp;
                    times++;
                }
            }
            if (nums[n - 1] == n) {
                times++;
            }
            System.out.println(times);
        }
    }
}
