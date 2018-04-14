package com.julyerr.realInterview.exams.netease.chunzhao2017;

import java.util.Scanner;

public class TakeTaxi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                y[i] = scanner.nextInt();
            }
            int gX = scanner.nextInt();
            int gY = scanner.nextInt();
            int wT = scanner.nextInt();
            int tT = scanner.nextInt();
            if (wT <= tT) {
                System.out.println(wT * (Math.abs(gX) + Math.abs(gY)));
            } else {
                int min = wT * (Math.abs(gX) + Math.abs(gY));
                boolean flag = true;
                for (int i = 0; i < n; i++) {
                    int a = Math.abs(x[i]);
                    int b = Math.abs(y[i]);
                    min = Math.min(min, wT * (a + b) + tT * (Math.abs(x[i] - gX) + Math.abs(y[i] - gY)));
                }
                System.out.println(min);
            }
        }
    }
}
