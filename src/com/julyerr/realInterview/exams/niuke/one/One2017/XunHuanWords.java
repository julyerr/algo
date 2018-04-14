package com.julyerr.realInterview.exams.niuke.one.One2017;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
*
5
picture
turepic
icturep
word
ordw

* */
public class XunHuanWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                String tmp = scanner.next();
                if (set.isEmpty() || !exists(set, tmp)) {
                    set.add(tmp);
                }
            }
            System.out.println(set.size());
        }
    }

    private static boolean exists(Set<String> set, String s) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            String tmp = s.substring(length - i, length) + s.substring(0, length - i);
            if (set.contains(tmp)) {
                return true;
            }
        }
        return false;
    }
}
