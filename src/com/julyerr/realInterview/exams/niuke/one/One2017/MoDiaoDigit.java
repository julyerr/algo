package com.julyerr.realInterview.exams.niuke.one.One2017;

import java.util.Arrays;
import java.util.Scanner;

public class MoDiaoDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            Arrays.sort(nums);
            boolean flag = false;
            boolean possible = true;
            int out = 0;
            for (int i = 0; i < n - 1; i++) {
                int dis = nums[i + 1] - nums[i];
                if (dis >= 3 || dis == 2 && flag) {
                    possible = false;
                    break;
                } else if (dis == 2) {
                    flag = true;
                    out = nums[i] + 1;
                }
            }
            if (possible) {
                if (flag) {
                    System.out.println(out);
                } else {
                    if (nums[0] == 1) {
                        System.out.println(nums[nums.length - 1]+1);
                    } else {
                        System.out.println((nums[0] - 1) + " " + (nums[nums.length - 1] + 1));
                    }
                }
            } else {
                System.out.println("mistake");
            }
        }
    }
}
