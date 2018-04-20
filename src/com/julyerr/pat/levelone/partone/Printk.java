package com.julyerr.pat.levelone.partone;

import java.util.Scanner;

public class Printk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String c = scanner.next();
            int k = 1;
            while (2 * k * k - 1 <= n) {
                k++;
            }
            k--;
            int rt = n - (2 * k * k - 1);
            int index = 0;
            for (int i = 2 * k - 1; i > 0; i -= 2) {
                for (int j = 0; j < index; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < i; j++) {
                    System.out.print(c);
                }
//                for (int j = 0; j < index; j++) {
//                    System.out.print(" ");
//                }
                System.out.println();
                index++;
            }
            index -= 2;
            for (int i = 3; i <= 2 * k - 1; i += 2) {
                for (int j = 0; j < index; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < i; j++) {
                    System.out.print(c);
                }
//                for (int j = 0; j < index; j++) {
//                    System.out.print(" ");
//                }
                System.out.println();
                index--;
            }
            System.out.println(rt);
        }
    }
}
