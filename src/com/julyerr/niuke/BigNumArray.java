package com.julyerr.niuke;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BigNumArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.next();
            }
            Arrays.sort(strings, new Comparator<String>() {
                @Override
//                重小到大排列
                public int compare(String o1, String o2) {
                    return (o2 + o1).compareTo(o1 + o2);
                }
            });
            System.out.println(String.join("", strings));
        }
    }
}
