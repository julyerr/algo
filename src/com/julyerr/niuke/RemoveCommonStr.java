package com.julyerr.niuke;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RemoveCommonStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line1 = scanner.nextLine();
            String line2 = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < line2.length(); i++) {
                map.put(line2.charAt(i), 0);
            }
            for (int i = 0; i < line1.length(); i++) {
                char c = line1.charAt(i);
                if (map.get(c) == null) {
                    stringBuilder.append(c);
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
