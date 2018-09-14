package com.julyerr.realInterview.exams.xiechen0329.qiu_2018;

import java.util.Scanner;

public class First {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        int count = 0;
        while(input!=0){
            count++;
            input = input&(input-1);
        }
        System.out.println(count);
    }
}
