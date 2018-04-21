package com.julyerr.pat.levelone.partone;

import java.util.Arrays;
import java.util.Scanner;

public class HighestLevel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[100001];
            int maxIndex = 0, max = 0;
            for (int i = 0; i < n; i++) {
                int index = scanner.nextInt();
                int grade = scanner.nextInt();
                nums[index] += grade;
                if (max < nums[index]) {
                    max = nums[index];
                    maxIndex = index;
                }
            }
            System.out.println(maxIndex + " " + max);
        }
    }
}
