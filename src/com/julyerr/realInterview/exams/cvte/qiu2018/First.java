package com.julyerr.realInterview.exams.cvte.qiu2018;

import java.util.Scanner;

public class First {
    public int help(int[] A,int[] B){
        if(A == null || B == null || A.length == 0 || B.length ==0){
            return 0;
        }
        int rt = 0;
        int[][] matrix = new int[A.length+1][B.length+1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if(A[i-1] == B[j-1]){
                    matrix[i][j] = matrix[i-1][j-1]+1;
                    rt = Math.max(rt,matrix[i][j]);
                }else{
                    matrix[i][j] = 0;
                }
            }
        }
        return rt;
    }

    public static void main(String[] args){
        int[] A = new int[]{1,2,3};
        int[] B = new int[]{2};
        System.out.println(new First().help(A,B));
    }
}
