package com.julyerr.realInterview.exams.netease.one0327;

import java.util.Scanner;

/*
 * 有点类似智力题
 * */
public class LayLamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            while (n-- > 0) {
                int len = scanner.nextInt();
                String line = scanner.next();
                int count = 0;
//                在需要防止路灯位置的右边放置路灯
                for (int i = 0; i < len; i++) {
                    if (line.charAt(i) == 'X') {
                        continue;
                    }
                    count++;
                    i += 2;
                }
                System.out.println(count);
            }
        }
    }
}
