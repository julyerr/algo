package com.julyerr.realInterview.exams.niuke.one.Before2017.one;

import java.util.Scanner;

public class TimeChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int count = 0;

            while(n>=10){
                int tmp = n;
                int next = 1;
                while(tmp>0){
                    next = next*(tmp%10);
                    tmp /=10;
                }
                count++;
                n = next;
            }

            System.out.println(count);
        }
    }
}