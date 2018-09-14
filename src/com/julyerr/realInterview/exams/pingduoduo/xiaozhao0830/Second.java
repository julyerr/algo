package com.julyerr.realInterview.exams.pingduoduo.xiaozhao0830;

import java.util.Arrays;
import java.util.Scanner;

/*
3 4
.oxo
o..o
.xox
* */
public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        char[][] matrix = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = scanner.next();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
        int[] bottom = new int[M];
        Arrays.fill(bottom,-1);
        for (int i = 0; i < M; i++) {
            for (int j = N-1; j >= 0 ; j--) {
                if(matrix[j][i] == 'x'){
                    bottom[i] = j;
                }else if(matrix[j][i] == 'o'){
                    if(bottom[i]>=0){
                        matrix[j][i] = '.';
                        matrix[--bottom[i]][i]='o';
                    }else{
                        matrix[j][i] = '.';
                    }
                }
            }
            if(bottom[i]>0){
                for (int j = --bottom[i]; j >=0 ; j--) {
                    matrix[j][i] = '.';
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
