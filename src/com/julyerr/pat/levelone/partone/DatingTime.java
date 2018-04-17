package com.julyerr.pat.levelone.partone;

import java.util.Scanner;

public class DatingTime {
    private static String[] strings = new String[]{
            "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String first = scanner.next();
            String second = scanner.next();
            String third = scanner.next();
            String fourth = scanner.next();
            int count = 0;
            for (int i = 0; i < first.length() && i < second.length(); i++) {
                char c = first.charAt(i);
                if (c == second.charAt(i)) {
                    if (count == 0 && Character.isUpperCase(c)) {
                        System.out.print(strings[c - 'A'] + " ");
                        count++;
                    } else if (count == 1) {
                        if (Character.isDigit(c)) {
                            System.out.print("0" + c);
                        } else {
                            System.out.print((c - 'A' + 10));
                        }
                        count++;
                    }
                }
            }
            for (int i = 0; i < third.length() && i < fourth.length(); i++) {
                char c = third.charAt(i);
                if (Character.isAlphabetic(c) && c == fourth.charAt(i)) {
                    if (i < 10) {
                        System.out.println(":0" + i);
                    } else {
                        System.out.println(":" + i);
                    }
                    break;
                }
            }
        }
    }
}
