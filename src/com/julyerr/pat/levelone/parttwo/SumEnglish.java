package com.julyerr.pat.levelone.parttwo;

import java.util.Scanner;

public class SumEnglish {
    public static void main(String[] args) {
        String[] strings = new String[]{
                "zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            int sum = 0;
            for (int i = 0; i < input.length(); i++) {
                sum += input.charAt(i) - '0';
            }
            String tmp = sum + "";
            System.out.print(strings[tmp.charAt(0) - '0']);
            for (int i = 1; i < tmp.length(); i++) {
                System.out.print(" " + strings[tmp.charAt(i) - '0']);
            }
            System.out.println();
        }
    }
}
