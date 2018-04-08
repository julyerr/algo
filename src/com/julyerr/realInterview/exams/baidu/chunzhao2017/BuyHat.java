package com.julyerr.realInterview.exams.baidu.chunzhao2017;

import java.util.Arrays;
import java.util.Scanner;

public class BuyHat {
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
            int i = 0;
            for (i = 0; i < n; i++) {
                index++;
                if (index == 3) {
                    break;
                }
                while (i + 1 < n && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
            if (index == 3) {
                System.out.println(nums[i]);
            } else {
                System.out.println(-1);
            }
        }
    }
}
