package com.julyerr.pat.levelone.partone;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CJB {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("C", "J");
        map.put("J", "B");
        map.put("B", "C");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Person A = new Person();
            Person B = new Person();
            while (n-- > 0) {
                String a = scanner.next();
                String b = scanner.next();
                if (a.equals(b)) {
                    A.ave++;
                    B.ave++;
                } else if (map.get(a).equals(b)) {
                    int tmp = A.map.get(a);
                    A.map.put(a, ++tmp);
                } else if (map.get(b).equals(a)) {
                    int tmp = B.map.get(b);
                    B.map.put(b, ++tmp);
                }
            }
            int aw = 0;
            int bw = 0;
            String aC = "B";
            String bC = "B";
            int minA = A.map.get("B");
            int minB = B.map.get("B");
            for (String string :
                    map.keySet()) {
                int a = A.map.get(string);
                int b = B.map.get(string);
                aw += a;
                bw += b;
                if (minA < a) {
                    minA = a;
                    aC = string;
                }
                if (minB < b) {
                    minB = b;
                    bC = string;
                }
            }
            System.out.println(aw + " " + A.ave + " " + bw);
            System.out.println(bw + " " + B.ave + " " + aw);
            System.out.println(aC + " " + bC);
        }
    }

    private static class Person {
        Map<String, Integer> map;
        int ave;

        public Person() {
            map = new HashMap<>();
            map.put("C", 0);
            map.put("J", 0);
            map.put("B", 0);
        }
    }
}
