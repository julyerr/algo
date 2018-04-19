package com.julyerr.pat.levelone.partone;

import java.util.Scanner;

public class ScienceDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            boolean pos = input.startsWith("+") ? true : false;
            input = input.substring(1);
            String[] partsA = input.split("\\.");
            String[] partsB = partsA[1].split("E");
            int mi = Integer.parseInt(partsB[1]);
            StringBuilder stringBuilder = new StringBuilder();
            if (mi == 0) {
                stringBuilder.append(partsA[0]).append(".").append(partsB[0]);
            } else if (mi > 0) {
                int len = mi - partsB[0].length();
                stringBuilder.append(partsA[0]);
                if (len >= 0) {
                    stringBuilder.append(partsB[0]);
                    while (len > 0) {
                        stringBuilder.append(0);
                        len--;
                    }
                } else {
                    stringBuilder.append(partsB[0].substring(0, mi)).append(".");
                    stringBuilder.append(partsB[0].substring(mi));
                }
            } else {
                stringBuilder.append(0).append(".");
                mi = -mi;
                mi--;
                while (mi > 0) {
                    stringBuilder.append(0);
                    mi--;
                }
                stringBuilder.append(partsA[0]);
                stringBuilder.append(partsB[0]);
            }
            System.out.println((pos ? "" : "-") + stringBuilder.toString());
        }
    }
}
