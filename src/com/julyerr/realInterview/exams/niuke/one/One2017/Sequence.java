package com.julyerr.realInterview.exams.niuke.one.One2017;

import java.util.Scanner;

public class Sequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt() * 2;
            int l = scanner.nextInt();
            int start = 0;
            for (int i = l; i <= 100; i++) {
                if (n % i != 0) {
                    continue;
                } else {
                    int tmp = n / i;
                    if ((tmp - i + 1) % 2 != 0) {
                        continue;
                    } else {
                        start = (tmp - i + 1) / 2;
                        l = i;
                        break;
                    }
                }
            }
            if (start == 0) {
                System.out.println("No");
            } else {
                System.out.print(start);
                for (int i = start + 1; i < start + l; i++) {
                    System.out.print(" " + i);
                }
                System.out.println();
            }
        }
    }
}
