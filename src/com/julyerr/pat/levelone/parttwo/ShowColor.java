package com.julyerr.pat.levelone.parttwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShowColor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = new char[]{
                'A', 'B', 'C'
        };
        while (scanner.hasNext()) {
            StringBuilder sb = new StringBuilder();
            sb.append("#");
            for (int i = 0; i < 3; i++) {
                int tmp = scanner.nextInt();
                int a = tmp / 13;
                int b = tmp % 13;
                if (a >= 10) {
                    sb.append(chars[a - 10]);
                } else {
                    sb.append(a);
                }

                if (b >= 10) {
                    sb.append(chars[b - 10]);
                } else {
                    sb.append(b);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
/*
25 43 71
* */
