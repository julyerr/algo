package com.julyerr.realInterview.exams.netease.neitui2018;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ColorfulBricks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < line.length(); i++) {
                Integer tmp = 0;
                char c = line.charAt(i);
                if ((tmp = map.get(c)) == null) {
                    tmp = 0;
                }
                map.put(c, tmp + 1);
                if (map.size() > 2) {
                    System.out.println(0);
                    break;
                }
            }
            if (map.size() == 1) {
                System.out.println(1);
            } else if (map.size() == 2) {
                System.out.println(2);
            }
        }
    }
}
