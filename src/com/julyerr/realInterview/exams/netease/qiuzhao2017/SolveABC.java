package com.julyerr.realInterview.exams.netease.qiuzhao2017;

import java.util.Scanner;

//相对简单的解方程
public class SolveABC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int AMB = scanner.nextInt();
            int BMC = scanner.nextInt();
            int APB = scanner.nextInt();
            int BPC = scanner.nextInt();
            int APCM2B = AMB - BMC;
            int APCP2B = APB + BPC;
            int APC = (APCM2B + APCP2B) >> 1;
            int B = (APCP2B - APC) >> 1;
            int A = APB - B;
            int C = BPC - B;
//            关键是验证解是否正确
            if (A - B != AMB || B - C != BMC) {
                System.out.println("No");
            } else {
                System.out.println(A + " " + B + " " + C);
            }
        }
    }
}
