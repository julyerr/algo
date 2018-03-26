package com.julyerr.realInterview.exams.netease;

import java.util.Scanner;

public class WaysChange {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            StringBuilder stringBuilder = new StringBuilder();
            while(n > 0){
                if(n % 2 ==0){
                    n = (n-2) >> 1;
                    stringBuilder.append(2);
                }else{
                    n = (n-1)>>1;
                    stringBuilder.append(1);
                }
            }
            System.out.println(stringBuilder.reverse().toString());
        }
    }
}
