package com.julyerr.realInterview.exams.niuke.qiuzhao.July;

import java.util.Scanner;

public class Mibijiao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        double a = y * Math.log(x);
        double b = x * Math.log(y);
        if(a<b){
            System.out.println("<");
        }else if(a == b) {
            System.out.println("=");
        }else{
            System.out.println(">");
        }
    }
}
