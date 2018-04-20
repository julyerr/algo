package com.julyerr.pat.levelone.partone;

import java.util.Scanner;

public class PeopleNum {
    private static final int YEAR = 2014;
    private static final int MONTH = 9;
    private static final int DAY = 6;
    private static final int MAX = YEAR * 10000 + MONTH * 100 + DAY;
    private static final int MIN = (YEAR - 200) * 10000 + MONTH * 100 + DAY;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int count = 0;
            String maxName = null, minName = null;
            int max = MIN;
            int min = MAX;

            for (int i = 0; i < N; i++) {
                String name = scanner.next();
                String[] tmp = scanner.next().split("/");
                int year = Integer.parseInt(tmp[0]);
                int month = Integer.parseInt(tmp[1]);
                int day = Integer.parseInt(tmp[2]);
                int cur = year * 10000 + month * 100 + day;
                if (cur >= MIN && cur <= MAX) {
                    count++;
                    if (cur >= max) {
                        max = cur;
                        maxName = name;
                    }
                    if (cur <= min) {
                        min = cur;
                        minName = name;
                    }
                }
            }
//            最大最小的相对性
            System.out.println(count + " " + minName + " " + maxName);
        }
    }

    private static class Person {
        String name;
        int year, month, day;

        public Person(String name, int year, int month, int day) {
            this.name = name;
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }
}
