package com.julyerr.pat.levelone.partone;

import java.util.Arrays;
import java.util.Scanner;

public class DigitHole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            boolean equals = true;
            if (input.length() == 4) {
                for (int i = 0; i < 3; i++) {
                    if (input.charAt(i) != input.charAt(i + 1)) {
                        equals = false;
                        break;
                    }
                }
            }else{
                equals = false;
            }
            if (equals) {
                System.out.println(input + " - " + input + " = 0000");
            } else {
                int tmp = Integer.parseInt(input);
                while (true) {
                    String cur = "" + tmp;
                    while (cur.length() < 4) {
                        cur = "0" + cur;
                    }
                    char[] chars = cur.toCharArray();
                    Arrays.sort(chars);
                    String second = new String(chars);
                    for (int i = 0; i < 2; i++) {
                        char c = chars[i];
                        chars[i] = chars[3 - i];
                        chars[3 - i] = c;
                    }
                    String first = new String(chars);
                    tmp = Integer.parseInt(first) - Integer.parseInt(second);
                    System.out.println(first + " - " + second + " = " + tmp);
                    if (tmp == 6174) {
                        break;
                    }
                }
            }
        }
    }
}
