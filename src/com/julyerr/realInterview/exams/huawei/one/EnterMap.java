package com.julyerr.realInterview.exams.huawei.one;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EnterMap {
    public static void main(String[] args) {
        Map<Character,Character> map = new HashMap<>();
        String standard = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String notRigt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int tmp = 'a'-'A';
        for (int i = 0; i < notRigt.length(); i++) {
            char a = notRigt.charAt(i);
            char b = standard.charAt(i);
            map.put(a,b);
            map.put(Character.toLowerCase(a),Character.toLowerCase(b));
        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if(Character.isAlphabetic(c)){
                    System.out.print(map.get(c));
                }else{
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}
