package com.julyerr.realInterview.exams.xiechen0329;

import java.util.Scanner;

public class RotateImage {
    public static void rotate(int[][] matrix) {
//        check validation
        if (matrix == null || matrix.length < 2 || matrix[0] == null || matrix[0].length < 2) {
            return;
        }

        int mx = matrix.length;
        int my = matrix[0].length;
//        对角线交换
        int mY = my - 1;
        for (int i = 0; i < mx - 1; i++) {
            for (int j = 0; j < mY; j++) {
                int newX = my - 1 - j;
                int newY = mx - 1 - i;

                int t = matrix[i][j];
                matrix[i][j] = matrix[newX][newY];
                matrix[newX][newY] = t;
            }
            mY--;
        }

//        进行中线交换
        int xLen = mx / 2;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < my; j++) {
                int newX = mx - 1 - i;

                int t = matrix[i][j];
                matrix[i][j] = matrix[newX][j];
                matrix[newX][j] = t;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        int[] nums =  new int[10000];
        while(scanner.hasNext()){
            nums[index++] = scanner.nextInt();
        }
        int width = (int) Math.sqrt(index);
        index = 0;
        int[][] matrix = new int[width][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j]  = nums[index++];
            }
        }
        rotate(matrix);
        for (int i = 0; i < width; i++) {
            System.out.print(matrix[i][0]);
            for (int j = 1; j < width; j++) {
                System.out.print(" "+matrix[i][j]);
            }
            System.out.println();
        }
    }
}
