package com.julyerr.niuke;

import java.util.Scanner;

public class Narcissus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            boolean has = false;
            boolean first = true;
            for (int i = start; i <= end; i++) {
                int tmpSum = (int) (Math.pow(i % 10, 3) + Math.pow(i % 100 / 10, 3) + Math.pow(i / 100, 3));
                if (tmpSum == i) {
                    has = true;
                    if (first) {
                        System.out.print(i);
                    } else {
                        System.out.print(" " + i);
                    }
                    first = false;
                }
            }
            if (!has) {
                System.out.print("no");
            }
            System.out.println();
        }
    }
}
