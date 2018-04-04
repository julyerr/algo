package com.julyerr.realInterview.exams.toutiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DisK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int m = scanner.nextInt();
                Integer tmp = 0;
                if ((tmp = map.get(m)) == null) {
                    tmp = 0;
                }
                tmp += 1;
                map.put(m, tmp);
            }
            int ret = 0;
            for (Integer integer :
                    map.keySet()) {
                if (map.get(integer + k) != null) {
                    if (k != 0 || map.get(integer + k) != 1) {
                        ret++;
                    }
                }
            }
            System.out.println(ret);
        }
    }
}
