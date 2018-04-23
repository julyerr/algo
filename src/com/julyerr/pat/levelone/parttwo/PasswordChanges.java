package com.julyerr.pat.levelone.parttwo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PasswordChanges {
    public static void main(String[] args) {
        Map<Character, Character> map = new HashMap<>();
        map.put('1', '@');
        map.put('0', '%');
        map.put('l', 'L');
        map.put('O', 'o');
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] names = new String[n];
            String[] passwords = new String[n];
            int index = 0;
            for (int i = 0; i < n; i++) {
                String name = scanner.next();
                String password = scanner.next();
                boolean changed = false;
                char[] chars = password.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    if (map.containsKey(chars[j])) {
                        chars[j] = map.get(chars[j]);
                        changed = true;
                    }
                }
                if (changed) {
                    names[index] = name;
                    passwords[index++] = new String(chars);
                }
            }
            if (index == 0) {
                if (n == 1) {
                    System.out.println("There is 1 account and no account is modified");
                } else {
                    System.out.printf("There are %d accounts and no account is modified\n", n);
                }
            } else {
                System.out.println(index);
                for (int i = 0; i < index; i++) {
                    System.out.println(names[i] + " " + passwords[i]);
                }
            }
        }
    }
}
