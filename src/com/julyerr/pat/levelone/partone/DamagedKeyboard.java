package com.julyerr.pat.levelone.partone;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class DamagedKeyboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String first = scanner.next().toUpperCase();
            String second = scanner.next().toUpperCase();
            int count = 0;
            Set<Character> set = new LinkedHashSet<>();
            for (int i = 0; i < first.length(); i++) {
                char c1 = first.charAt(i);
                char c2 = second.charAt(count);
                if (c1 == c2) {
                    count++;
                    if (count >= second.length()) {
                        count--;
                    }
                } else {
                    if (!set.contains(c1)) {
                        set.add(c1);
                    }
                }
            }
            for (Character c :
                    set) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
