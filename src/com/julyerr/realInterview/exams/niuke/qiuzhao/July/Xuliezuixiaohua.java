package com.julyerr.realInterview.exams.niuke.qiuzhao.July;

import java.util.Scanner;

public class Xuliezuixiaohua {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int result = (n - 1) / (k - 1);
        if ((n - 1) % (k - 1) > 0) {
            result++;
        }
        System.out.println(result);
    }
}
