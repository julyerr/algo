package com.julyerr.pat.levelone.partone;

import java.util.Scanner;

public class ABC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                long a = scanner.nextLong();
                long b = scanner.nextLong();
                long c = scanner.nextLong();
                if (a + b > c) {
                    System.out.println("Case #" + (i + 1) + ": " + true);
                } else {
                    System.out.println("Case #" + (i + 1) + ": " + false);
                }
            }
        }
    }
}
