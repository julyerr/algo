package com.julyerr.pat.levelone.parttwo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 开始没有明确题目的意思，radix的取值可以超过36,
 * 可以选择二分的思路，如果可以表示的话，缩小范围；
 * 否则直接返回
 * */
public class ScaleShow {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        for (char i = '0'; i <= '9'; i++) {
            map.put(i, i - '0');
        }
        for (char i = 'a'; i <= 'z'; i++) {
            map.put(i, i - 'a' + 10);
        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String first = scanner.next();
            String second = scanner.next();
            int tag = scanner.nextInt();
            long radix = scanner.nextLong();

            long real = 0;
            if (tag == 1) {
                for (int i = 0; i < first.length(); i++) {
                    real = real * radix + map.get(first.charAt(i));
                }
            } else {
                for (int i = 0; i < second.length(); i++) {
                    real = real * radix + map.get(second.charAt(i));
                }
                second = first;
            }

            char maxC = '0';
            for (int i = 0; i < second.length(); i++) {
                if (maxC < second.charAt(i)) {
                    maxC = second.charAt(i);
                }
            }

            long left = map.get(maxC) + 1;
            long right = real;
            boolean flag = false;
            long rt = 0;
//            可能出现left=right的情况下取到结果值
            while (left <= right) {
                long tmp = (left + right) >> 1;
                long sum = 0;
                for (int i = 0; i < second.length(); i++) {
                    sum = sum * tmp + map.get(second.charAt(i));
                }
                if (sum == real) {
                    flag = true;
                    rt = tmp;
                    right = tmp - 1;
                } else if (sum < real) {
                    left = tmp + 1;
                } else {
                    right = tmp - 1;
                }
            }

            if (!flag) {
                System.out.println("Impossible");
            } else {
                System.out.println(rt);
            }
        }
    }
}
