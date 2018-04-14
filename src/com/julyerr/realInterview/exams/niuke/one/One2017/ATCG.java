package com.julyerr.realInterview.exams.niuke.one.One2017;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATCG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Character> map = new HashMap<>();
        map.put('A', 'T');
        map.put('T', 'A');
        map.put('C', 'G');
        map.put('G', 'C');
        while (scanner.hasNext()) {
            String first = scanner.next();
            String second = scanner.next();
            int ret = 0;
            for (int i = 0; i < first.length(); i++) {
                if (map.get(first.charAt(i)) != second.charAt(i)) {
                    ret++;
                }
            }
            System.out.println(ret);
        }
    }
}
