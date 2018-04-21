package com.julyerr.pat.levelone.partone;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] nums = new int[100001];
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int tmp = scanner.nextInt();
                nums[tmp]++;
            }
            int k = scanner.nextInt();
            System.out.print(nums[scanner.nextInt()]);
            for (int i = 0; i < k - 1; i++) {
                System.out.print(" " + nums[scanner.nextInt()]);
            }
            System.out.println();
        }
    }
}
/*
10

60 75 90 55 75 99 82 90 75 50

3 75 90 88

* */