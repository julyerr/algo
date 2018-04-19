package com.julyerr.pat.levelone.partone;

import java.util.Scanner;

public class Nums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] nums = new int[10];
            int zeros = scanner.nextInt();
            StringBuilder stringBuilder = new StringBuilder();
            boolean flag = true;
            for (int i = 1; i < 10; i++) {
                nums[i] = scanner.nextInt();
                while (nums[i] > 0) {
                    stringBuilder.append(i);
                    nums[i]--;
                    if (flag) {
                        while (zeros > 0) {
                            stringBuilder.append(0);
                            zeros--;
                        }
                        flag = false;
                    }
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
