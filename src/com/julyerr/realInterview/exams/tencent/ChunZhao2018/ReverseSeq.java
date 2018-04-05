package com.julyerr.realInterview.exams.tencent.ChunZhao2018;

import java.util.Scanner;

public class ReverseSeq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long n =scanner.nextInt();
            long m =scanner.nextInt();
            System.out.println(m*n/2);
        }
    }
}
