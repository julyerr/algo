package com.julyerr.pat.levelone.parttwo;

import java.util.Scanner;

public class WorldCupBetting {
    public static void main(String[] args) {
        char[] chars = new char[]{
                'W', 'T', 'L'
        };
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double[] max = new double[3];
            int[] index = new int[3];
            for (int i = 0; i < 3; i++) {
                max[i] = -1;
                index[i] = -1;
                for (int j = 0; j < 3; j++) {
                    double tmp = scanner.nextDouble();
                    if (max[i] < tmp) {
                        max[i] = tmp;
                        index[i] = j;
                    }
                }
            }
            double whole = (max[0] * max[1] * max[2] * 0.65 - 1) * 2;
            for (int i = 0; i < 3; i++) {
                System.out.print(chars[index[i]] + " ");
            }
//            System.out.printf("%f\n",whole);
            System.out.printf("%.2f\n", round(whole * 100) * 1.0 / 100);
        }
    }

    public static long round(double t) {
        String tmp = t + "";
//        没有小数点
        if (tmp.indexOf('.') == -1) {
            return (long) t;
        }

        boolean flag = t >= 0 ? true : false;
        String[] tmps = tmp.split("\\.");
        Long rt = Long.parseLong(tmps[0]);
        if (tmps[1].charAt(0) >= '5') {
            if (flag) {
                return rt + 1;
            }
            return rt - 1;
        }
        return rt;
    }
}
