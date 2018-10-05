package com.julyerr.realInterview.exams.cvte.qiu2018;

import java.util.Scanner;

public class Second {
    public String help(String photo,int maxLength){
        boolean flag = false;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < photo.length(); i++) {
            char c  = photo.charAt(i);
            if(c == '1'){
                if(flag){
                    int count = 0;
                    for (int j = stringBuilder.length()-1; j >= 0 ; j--) {
                        if(stringBuilder.charAt(j) == '-'){
                            stringBuilder.deleteCharAt(j);
                            count++;
                        }
                    }
                    for (int j = 0; j < count; j++) {
                        stringBuilder.append("00");
                    }
                }
                flag = true;
            }else if(c == '0'){
                flag = false;
            }
            stringBuilder.append(c);
            if(stringBuilder.length()>=maxLength){
                break;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        System.out.println(new Second().help("01-1--1-111",13));
    }
}
