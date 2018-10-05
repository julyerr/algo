package com.julyerr.realInterview.exams.zoom;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextInt());
        }
        int m = scanner.nextInt();
        boolean flag = true;
        for (int i = 0; i < m; i++) {
            int t = scanner.nextInt();
            if (set.contains(t)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
