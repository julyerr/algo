package com.julyerr.pat.levelone.partone;

import java.util.Scanner;

public class LooseCharge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] first = scanner.next().split("\\.");
            String[] second = scanner.next().split("\\.");
            int total1 = 0, total2 = 0;
            total1 = 29 * 17 * Integer.parseInt(first[0]) + 29 * Integer.parseInt(first[1]) + Integer.parseInt(first[2]);
            total2 = 29 * 17 * Integer.parseInt(second[0]) + 29 * Integer.parseInt(second[1]) + Integer.parseInt(second[2]);

            int dis = Math.abs(total1 - total2);
            int a = dis / (29 * 17);
            int b = (dis - a * 29 * 17) / 29;
            int c = dis % 29;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a).append(".");
            stringBuilder.append(b).append(".");
            stringBuilder.append(c);
            if (total1 > total2) {
                System.out.println("-" + stringBuilder.toString());
            } else {
                System.out.println(stringBuilder.toString());
            }
        }
    }
}
