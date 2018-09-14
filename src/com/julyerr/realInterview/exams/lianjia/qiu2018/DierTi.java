package com.julyerr.realInterview.exams.lianjia.qiu2018;

import java.util.Scanner;

public class DierTi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[14];
        String line = scanner.next();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                nums[c - '0']++;
            } else {
                switch (c) {
                    case 'A':
                        nums[1]++;
                        break;
                    case 'T':
                        nums[10]++;
                        break;
                    case 'J':
                        nums[11]++;
                        break;
                    case 'Q':
                        nums[12]++;
                        break;
                    case 'K':
                        nums[13]++;
                        break;
                }
            }
        }

    }
}
