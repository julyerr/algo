package com.julyerr.pat.levelone.partone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Zhuzi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String first = scanner.nextLine();
            String second = scanner.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < first.length(); i++) {
                Integer tmp;
                char c = first.charAt(i);
                if ((tmp = map.get(c)) == null) {
                    tmp = 0;
                }
                map.put(c, ++tmp);
            }

            int notContainsCount = 0;
            for (int i = 0; i < second.length(); i++) {
                char c = second.charAt(i);
                Integer tmp = map.get(c);
                if (tmp == null) {
                    notContainsCount++;
                } else {
                    if (tmp <= 0) {
                        notContainsCount++;
                    }
                    map.put(c, --tmp);
                }
            }
            if (notContainsCount == 0) {
                System.out.println("Yes " + (first.length() - second.length()));
            } else {
                System.out.println("No " + notContainsCount);
            }
        }
    }
}
/*
ppRYYGrrYBR2258
YrR8RrY
* */