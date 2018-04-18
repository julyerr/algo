package com.julyerr.pat.levelone.partone;

import java.util.Scanner;

public class PAB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int A = scanner.nextInt();
            int DA = scanner.nextInt();
            int B = scanner.nextInt();
            int DB = scanner.nextInt();
            int a = pab(A, DA);
            int b = pab(B, DB);
            System.out.println(a + b);
        }
    }

    private static int pab(int a, int b) {
        String tmp = a + "";
        char c = (char) (b + '0');
        int rt = 0;
        for (int i = tmp.length() - 1; i >= 0; i--) {
            if (tmp.charAt(i) == c) {
                rt = rt * 10 + b;
            }
        }
        return rt;
    }
}
