package com.julyerr.realInterview.simulation;

import java.util.Scanner;

public class BaskGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            boolean[] hasBall = new boolean[p];
            int i = 0;
            for (i = 0; i < n; i++) {
                int tmp = nums[i] % p;
                if (hasBall[tmp]) {
                    System.out.println(i + 1);
                    break;
                } else {
                    hasBall[tmp] = true;
                }
            }
            if (i == n) {
                System.out.println(-1);
            }
        }
    }
}
