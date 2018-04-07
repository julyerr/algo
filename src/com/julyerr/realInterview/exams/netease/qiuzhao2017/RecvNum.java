package com.julyerr.realInterview.exams.netease.qiuzhao2017;

import java.util.Scanner;

public class RecvNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(recvNum(recvNum(x) + recvNum(y)));
        }
    }

    private static int recvNum(int n) {
        int rt = 0;
        while (n > 0) {
            rt = rt * 10 + n % 10;
            n = n / 10;
        }
        return rt;
    }
}
