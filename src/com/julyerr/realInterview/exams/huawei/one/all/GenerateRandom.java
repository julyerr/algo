package com.julyerr.realInterview.exams.huawei.one.all;

import java.util.Arrays;
import java.util.Scanner;

public class GenerateRandom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            Arrays.sort(nums);
            int index = 0;
            for (int i = 0; i < n; i++) {
                nums[index++] = nums[i];
                while (i + 1 < n && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
            for (int i = 0; i < index; i++) {
                System.out.println(nums[i]);
            }
        }
    }
}
