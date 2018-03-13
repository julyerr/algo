package com.julyerr.niuke;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Necklace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            int len = s.length();
            int min = len;
            s = s + s;
            int length = s.length();
            Map<Character, Integer> map = new HashMap<>();
            int index = 0;
            int left = 0;
            int count = 0;
            while (true) {
//                构成一段项链
                while (index < length && count < 5) {
                    char c = s.charAt(index);
                    if (c == 'A' || c == 'B' || c == 'C' || c == 'D' || c == 'E') {
                        Integer tmp;
                        if ((tmp = map.get(c)) == null) {
                            tmp = 0;
                        }
                        tmp++;
                        map.put(c, tmp);
                        if (tmp == 1) {
                            count++;
                        }
                    }
                    index++;
                }
                if (count < 5) {
                    break;
                }
                min = Math.min(min, index - left);
//                left往右移动空出位置
                char c = s.charAt(left);
                if (c == 'A' || c == 'B' || c == 'C' || c == 'D' || c == 'E') {
                    int times = map.get(c);
                    times--;
                    if (times == 0) {
                        count--;
                    }
                    map.put(c, times);
                }
                left++;
            }
            System.out.println(len - min);
        }
    }
}
