package com.julyerr.realInterview.exams.huawei.one;

import java.util.Scanner;

public class ReceiveEn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] nums = new int[21];
            for (int i = 0; i < 21; i++) {
                nums[i] = scanner.nextInt();
            }
            int maxIndex = 0;
            int maxEn = nums[0] + nums[1] + nums[2] + nums[3];
            for (int i = 1; i < 18; i++) {
                int tmp = maxEn - nums[i - 1] + nums[i + 3];
                if (tmp > maxEn) {
                    maxEn = tmp;
                    maxIndex = i;
                }
            }
            System.out.println(maxEn+" "+maxIndex);
        }
    }
}
