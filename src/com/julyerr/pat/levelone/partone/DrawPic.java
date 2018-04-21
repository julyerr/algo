package com.julyerr.pat.levelone.partone;

import java.util.Scanner;

public class DrawPic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String c = scanner.next();
            for (int i = 0; i < n; i++) {
                System.out.print(c);
            }
            System.out.println();

            int tmp = (int) (Math.round(n * 1.0 / 2) - 2);
            for (int i = 0; i < tmp; i++) {
                System.out.print(c);
                for (int j = 1; j < n - 1; j++) {
                    System.out.print(" ");
                }
                System.out.print(c);
                System.out.println();
            }

            for (int i = 0; i < n; i++) {
                System.out.print(c);
            }
            System.out.println();

        }
    }
}
