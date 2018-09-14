package com.julyerr.realInterview.exams.niuke.qiuzhao.July;

import java.util.Scanner;

public class XiguaTang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int tmp = scanner.nextInt();
            int bit = 1;
            while ((bit & tmp) == 0) {
                bit = bit << 1;
                sum++;
            }
        }
        System.out.println(sum);
    }
}
