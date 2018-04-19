package com.julyerr.pat.levelone.partone;

import java.util.*;

public class Times {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            Map<Character,Integer> map = new TreeMap<>();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                Integer tmp = 0;
                if((tmp = map.get(c))==null){
                    tmp = 0;
                }
                map.put(c,++tmp);
            }
            for (Character c :
                    map.keySet()) {
                System.out.println(c+":"+map.get(c));
            }
        }
    }
}
