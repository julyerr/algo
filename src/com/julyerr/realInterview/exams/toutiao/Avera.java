package com.julyerr.niuke.company.toutiao;

import java.util.Scanner;

public class Avera {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] nums1 =new int[n];
            int[] nums2 =new int[n];

            long sum1 = 0;
            long sum2 = 0;
            for (int i = 0; i < n; i++) {
                nums1[i] = scanner.nextInt();
                sum1+= nums1[i];
            }

            for (int i = 0; i < m; i++) {
                nums2[i] = scanner.nextInt();
                sum2+= nums2[i];
            }

            int index = 0;

        }
    }
}
