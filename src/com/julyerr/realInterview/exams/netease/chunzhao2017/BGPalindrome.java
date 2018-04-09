package com.julyerr.realInterview.exams.netease.chunzhao2017;

import java.util.Scanner;

public class BGPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            int min1 = 0;
            int min2 = 0;
            int index1 = 0;
            int index2 = 0;
//            简单的调整位置即可
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == 'G') {
                    min1 += i - index1++;
                }
                if (c == 'B') {
                    min2 += i - index2++;
                }
            }
            System.out.println(Math.min(min1, min2));
        }
    }
}
