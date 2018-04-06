package com.julyerr.realInterview.exams.huawei.one.all;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HexChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        String hex = "ABCDEF";
        int count = 10;
        for (int i = 0; i < hex.length(); i++) {
            map.put(hex.charAt(i), count);
            count++;
        }
        while (scanner.hasNext()) {
            String string = scanner.next();
            if (string.startsWith("0x")) {
                string = string.substring(2);
            }
            long sum = 0;
            long bit = 1;
            for (int i = string.length() - 1; i >= 0; i--) {
                char c = string.charAt(i);
                if (Character.isAlphabetic(c)) {
                    sum += bit * map.get(c);
                } else {
                    sum += (c - '0')*bit;
                }
                bit *= 16;
            }
            System.out.println(sum);
        }
    }
}
