package com.julyerr.realInterview.exams.netease.chunzhao2017;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * 这道题，关键是输入的地方出现一个错误，通过查看提示的信息可以进行相应的改进
 * */
public class RememberWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Set<String> set = new HashSet<>();
        Set<String> words = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String tmp = scanner.next();
            set.add(tmp);
        }
        for (int i = 0; i < m; i++) {
            String tmp = scanner.next();
            words.add(tmp);
        }
        int grades = 0;
        for (String word :
                set) {
            if (words.contains(word)) {
                grades += word.length() * word.length();
            }
        }
        System.out.println(grades);
    }
}
