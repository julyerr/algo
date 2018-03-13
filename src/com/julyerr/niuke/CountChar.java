package com.julyerr.niuke;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Map<Character,Integer> map = new HashMap<>();
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if(!Character.isAlphabetic(c)){
                    continue;
                }
                Integer tmp ;
                if((tmp=map.get(c))==null){
                    tmp = 0;
                }
                tmp++;
                if(tmp>=3){
                    System.out.println(c);
                    break;
                }
                map.put(c,tmp);
            }
        }
    }
}
