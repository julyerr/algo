package com.julyerr.pat.levelone.partone;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KeyBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String first = scanner.nextLine();
            String second = scanner.nextLine();
            Set<Character> set = new HashSet<>();
            boolean Plus = first.contains("+") ? true : false;
            first = first.toLowerCase();
            for (int i = 0; i < first.length(); i++) {
                set.add(first.charAt(i));
            }
            for (int i = 0; i < second.length(); i++) {
                char c = second.charAt(i);
                if (Plus) {
                    if (!set.contains(c)) {
                        if (Character.isAlphabetic(c)) {
                            if (Character.isLowerCase(c)) {
                                System.out.print(c);
                            }
                        } else {
                            System.out.print(c);
                        }
                    }
                } else {
                    if (!set.contains(Character.toLowerCase(c))) {
                        System.out.print(c);
                    }
                }
            }
            System.out.println();
        }
    }
}

/*
7+IE.
7_This_is_a_test.
* */