package com.julyerr.realInterview.exams.pingduoduo.xiaozhao0805;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int len = input.length() / 4;
        char[][] matrix = new char[len+1][len+1];
        int index = 0;
        for (int i = 0; i < len + 1; i++) {
            matrix[0][i] = input.charAt(index++);
        }
        for (int i = 1; i < len; i++) {
            matrix[i][len] = input.charAt(index++);
        }
        for (int i = len; i >= 0; i--) {
            matrix[len][i] = input.charAt(index++);
        }
        for (int i = len-1; i >= 1; i--) {
            matrix[i][0] = input.charAt(index++);
        }
        for (int i = 0; i < len+1; i++) {
            for (int j = 0; j < len+1; j++) {
                if(matrix[i][j]!=0){
                    System.out.print(matrix[i][j]);
                }else{
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }
}
/*
abcdefghijklmnop
* */