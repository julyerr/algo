package com.julyerr.realInterview.exams.netease.qiuzhao2016;

import java.util.Scanner;

public class DaPao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int R = scanner.nextInt();
            int[] x = new int[3];
            int[] y = new int[3];
            for (int i = 0; i < 3; i++) {
                x[i] = scanner.nextInt();
                y[i] = scanner.nextInt();
            }
            int x0 = scanner.nextInt();
            int y0 = scanner.nextInt();

            int R2 = R * R;
            int ret = 0;
            for (int i = 0; i < 3; i++) {
                int tmp = (x[i] - x0) * (x[i] - x0) + (y[i] - y0) * (y[i] - y0);
                if (tmp <= R * R) {
                    ret++;
                }
            }
            System.out.println(ret + "x");
        }
    }
}
