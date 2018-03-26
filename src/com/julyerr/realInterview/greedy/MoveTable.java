package com.julyerr.realInterview.greedy;

import java.util.Scanner;

public class MoveTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int r = scanner.nextInt();
            int x0 = scanner.nextInt();
            int y0 = scanner.nextInt();
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();

//            计算过程可能出现溢出的情况
            long t1 = x0 - x1;
            t1 *= t1;
            long t2 = y0 - y1;
            t2 *= t2;
            int dis = (int) Math.sqrt(t1+t2);
            long RR_2 = 2 * r ;
            long remain = dis % RR_2 == 0 ? 0 : 1;
            int step = (int) (dis / RR_2);
            System.out.println(step + remain);
        }
    }
}
