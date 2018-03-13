package com.julyerr.niuke;

import java.util.Scanner;

public class RemoveN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String num = scanner.next();
            int len = scanner.nextInt();
            StringBuilder stringBuilder = new StringBuilder(num);
            int count = 0;
            while (count < len) {
                int index = 0;
                int length = stringBuilder.length();
                while (index < length - 1 && stringBuilder.charAt(index) >= stringBuilder.charAt(index + 1)) {
                    index++;
                }
                stringBuilder.deleteCharAt(index);
                count++;
            }

            System.out.println(stringBuilder.toString());
        }
    }
}
