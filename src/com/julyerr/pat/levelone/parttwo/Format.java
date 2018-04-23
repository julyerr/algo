package com.julyerr.pat.levelone.parttwo;

import java.util.Scanner;

public class Format {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = a + b;
            if (c > -1000 && c < 1000) {
                System.out.println(c);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                if (c < 0) {
                    stringBuilder.append("-");
                    c = -c;
                }
                if (c < 1000000) {
                    stringBuilder.append(c / 1000).append(",").append(c % 1000);
                } else {
                    stringBuilder.append(c / 1000000).append(",").append(c % 1000000 / 1000).append(",")
                            .append(c % 1000);
                }
                System.out.println(stringBuilder.toString());
            }
        }
    }
}
