package com.julyerr.pat.levelone.parttwo;

import java.util.Arrays;
import java.util.Scanner;

public class MagicCoupon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            long[] coupons = new long[n];
            for (int i = 0; i < n; i++) {
                coupons[i] = scanner.nextLong();
            }
            int m = scanner.nextInt();
            long[] products = new long[m];
            for (int i = 0; i < m; i++) {
                products[i] = scanner.nextLong();
            }
            Arrays.sort(coupons);
            Arrays.sort(products);
            int l1, l2, r1, r2;
            l1 = l2 = 0;
            r1 = n - 1;
            r2 = m - 1;
            long sum = 0;
            while (l1 < n && l2 < m && coupons[l1] < 0 && products[l2] < 0) {
                sum += coupons[l1] * products[l2];
                l2++;
                l1++;
            }
//            可以取到l1、l2的值
            while (r1 >= l1 && r2 >= l2 && coupons[r1] > 0 && products[r2] > 0) {
                sum += coupons[r1] * products[r2];
                r1--;
                r2--;
            }
            System.out.println(sum);
        }
    }
}
