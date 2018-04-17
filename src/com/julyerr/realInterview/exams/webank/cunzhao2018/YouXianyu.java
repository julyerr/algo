package com.julyerr.realInterview.exams.webank.cunzhao2018;

import java.util.Arrays;
import java.util.Scanner;

public class YouXianyu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
//            素数筛选
            boolean[] flags = new boolean[n + 1];
            Arrays.fill(flags, true);
            flags[1] = false;
            for (int i = 2; i <= n; i++) {
                for (int j = 2; i * j <= n; j++) {
                    flags[i * j] = false;
                }
            }
            for (int i = 1; i <= n; i++) {
                if (flags[i]) {
                    for (int j = i; i * j <= n; j *= i) {
                        flags[i * j] = true;
                    }
                }
            }
            int count = 0;
            for (int i = 0; i <= n; i++) {
                if (flags[i]) {
                    count++;
                }
            }
            System.out.println(count - 1);
        }
    }
}
