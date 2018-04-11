package com.julyerr.realInterview.exams.netease.chunzhao2017;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int w = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            Set<Double> set = new HashSet<>();
            for (int i = w; i <= x; i++) {
                for (int j = y; j <= z; j++) {
                    set.add(i *1.0/ j);
                }
            }
            System.out.println(set.size());
        }
    }
}
