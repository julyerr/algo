package com.julyerr.realInterview.exams.aiyiqi.qiu2018;

import java.util.Scanner;

public class First {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < 3; i++) {
            sumA += input.charAt(i) - '0';
        }
        for (int i = 3; i < 6; i++) {
            sumB += input.charAt(i) - '0';
        }
        int min = Math.abs(sumA-sumB);
        if(min%9==0){
            System.out.println(min/9);
        }else{
            System.out.println(min/9+1);
        }
    }
}
