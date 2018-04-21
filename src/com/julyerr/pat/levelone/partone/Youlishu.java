package com.julyerr.pat.levelone.partone;

import java.util.Scanner;

public class Youlishu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String first = scanner.next();
            String second = scanner.next();
            String[] firsts = first.split("/");
            String[] seconds = second.split("/");
            int[] fs = new int[2];
            int[] ss = new int[2];
            for (int i = 0; i < 2; i++) {
                fs[i] = Integer.parseInt(firsts[i]);
            }
            for (int i = 0; i < 2; i++) {
                ss[i] = Integer.parseInt(seconds[i]);
            }

            int[][] rt = new int[4][2];

            String one = null, two = null;
            if (fs[0] != 0 && ss[0] != 0) {
                int tmp = fs[1] * ss[1];
                for (int i = 0; i < 4; i++) {
                    rt[i][1] = tmp;
                }
                rt[0][0] = fs[0] * ss[1] + fs[1] * ss[0];
                rt[1][0] = fs[0] * ss[1] - fs[1] * ss[0];
                rt[2][0] = fs[0] * ss[0];
                rt[3][0] = fs[0] * ss[1];
                rt[3][1] = fs[1] * ss[0];

                one = format(fs[0], fs[1]);
                two = format(ss[0], ss[1]);
            } else if (fs[0] == 0 && ss[0] != 0) {
                rt[0][0] = ss[0];
                rt[0][1] = ss[1];
                rt[1][0] = -ss[0];
                rt[1][1] = ss[1];
                one = "0";
                two = format(ss[0], ss[1]);
            } else if (ss[0] == 0 && fs[0] != 0) {
                rt[0][0] = fs[0];
                rt[0][1] = fs[1];
                rt[1][0] = fs[0];
                rt[1][1] = fs[1];
                one = format(fs[0], fs[1]);
                two = "0";
            } else {
                one = "0";
                two = "0";
            }

            System.out.println(one + " + " + two + " = " + (rt[0][0] == 0 ? "0" : format(rt[0][0], rt[0][1])));
            System.out.println(one + " - " + two + " = " + (rt[1][0] == 0 ? "0" : format(rt[1][0], rt[1][1])));
            System.out.println(one + " * " + two + " = " + (rt[2][0] == 0 ? "0" : format(rt[2][0], rt[2][1])));
            System.out.print(one + " / " + two + " = ");
            if (ss[0] == 0) {
                System.out.println("Inf");
            } else {
                System.out.println(rt[3][0] == 0 ? "0" : format(rt[3][0], rt[3][1]));
            }
        }
    }

    private static int gcd(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    private static String format(int a, int b) {
        boolean minus = false;
        String rt = "";
        if (a < 0 && b > 0 || a > 0 && b < 0) {
            minus = true;
            a = Math.abs(a);
            b = Math.abs(b);
            rt += "(-";
        }
        if (a >= b) {
            rt += a / b + "";
            a = a - a / b * b;
            if (a == 0) {
                if (minus) {
                    rt += ")";
                }
                return rt;
            } else {
                rt += " ";
            }
        }
        int c = gcd(a, b);
        a /= c;
        b /= c;
        rt += a + "/" + b;
        if (minus) {
            rt += ")";
        }
        return rt;
    }
}
/*
2/3 -4/2
* */