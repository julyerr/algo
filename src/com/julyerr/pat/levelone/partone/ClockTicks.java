package com.julyerr.pat.levelone.partone;

import java.util.Scanner;

/*
 * Math.round() 进行四舍五入操作
 * */
public class ClockTicks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int C1 = scanner.nextInt();
            int C2 = scanner.nextInt();
            double t = (C2 - C1) * 1.0 / 100;
            int hour = (int) (t / 3600);
            int minute = (int) ((t - 3600 * hour) / 60);
            t = Math.round(t - 3600 * hour - 60 * minute);
            System.out.printf("%02d:%02d:%02d\n", hour, minute, (int) t);
        }
    }
}
