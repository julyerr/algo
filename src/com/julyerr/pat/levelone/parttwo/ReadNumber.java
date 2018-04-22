package com.julyerr.pat.levelone.parttwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadNumber {
    private static String[] strings = new String[]{
            "ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            StringBuilder sb = new StringBuilder();
            List<String> list = new ArrayList<>();
            if (num < 0) {
                list.add("Fu");
                num = -num;
            }
            int a = num / 100000000;
            int b = num % 100000000 / 10000;
            int c = num % 10000;
            if (a != 0) {
                list.add(strings[a]);
                list.add("Yi");
            }
            if (b != 0 && c != 0) {
                if (b < 1000 && a != 0) {
                    list.add("ling");
                }
                list.addAll(format(b));
                list.add("Wan");
                if (c < 1000) {
                    list.add("ling");
                }
                list.addAll(format(c));
            } else if (b != 0 && c == 0) {
                if (b < 1000 && a != 0) {
                    list.add("ling");
                }
                list.addAll(format(b));
                list.add("Wan");
            } else if (b == 0 && c != 0) {
                if (a != 0) {
                    list.add("ling");
                }
                list.addAll(format(c));
            }
            if (list.size() == 0) {
                System.out.println("ling");
            } else {
                System.out.println(String.join(" ", list));
            }
        }
    }

    private static List<String> format(int a) {
        List<String> rt = new ArrayList<>();
        int qian = a / 1000;
        int bai = a % 1000 / 100;
        int shi = a % 100 / 10;
        int ge = a % 10;
        if (qian != 0) {
            rt.add(strings[qian]);
            rt.add("Qian");
        }
        if (bai != 0) {
            rt.add(strings[bai]);
            rt.add("Bai");
        }

        if (qian != 0 && bai == 0 && (shi != 0 || ge != 0)) {
            rt.add("ling");
        }

        if (shi != 0) {
            rt.add(strings[shi]);
            rt.add("Shi");
        }

        if ((qian != 0 || bai != 0) && shi == 0 && ge != 0) {
//        7005这种情况
            if (!rt.get(rt.size() - 1).equals("ling")) {
                rt.add("ling");
            }
        }
        if (ge != 0) {
            rt.add(strings[ge]);
        }
        return rt;
    }
}
