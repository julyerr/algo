package com.julyerr.realInterview.exams.niuke.one;

import java.util.Scanner;

public class SimpleEncode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(Character.isAlphabetic(c)){
                    if(c=='z'||c=='Z'){
                        c = (char) (c-25);
                    }else{
                        c = (char) (c+1);
                    }
                }
                stringBuilder.append(c);
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
