package com.julyerr.realInterview.exams.jd.chunzhao2018;

import java.util.Scanner;

public class XY {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                long N = scanner.nextLong();
                if ((N & 1) != 0) {
                    System.out.println("No");
                } else {
                    long bit = 1;
                    long tmp = N;
                    while ((N & 1) != 1) {
                        N >>= 1;
                        bit <<= 1;
                    }
                    System.out.println(tmp / bit + " " + bit);
                }
            }
        }
    }
}
