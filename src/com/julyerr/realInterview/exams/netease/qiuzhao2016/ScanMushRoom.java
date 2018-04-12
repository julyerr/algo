package com.julyerr.realInterview.exams.netease.qiuzhao2016;

import java.util.Scanner;

public class ScanMushRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int K = scanner.nextInt();
            int[][] matrix = new int[N + 1][M + 1];
            for (int i = 0; i < K; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                matrix[x][y]++;
            }
            int first = maxMushroom(matrix, matrix.length, matrix[0].length);
            int second = maxMushroom(matrix, matrix.length, matrix[0].length);
            System.out.println(first + second);
        }
    }

    private static int maxMushroom(int[][] matrix, int n, int m) {
        int max = 0;
        int startX = 0, startY = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                int tmp = 0;
                for (int k = i; k < i + 3 && k < n; k++) {
                    for (int l = j; l < j + 3 && l < m; l++) {
                        if (matrix[k][l] != 0) {
                            tmp++;
                        }
                    }
                }
                if (max < tmp) {
                    max = tmp;
                    startX = i;
                    startY = j;
                }
            }
        }
//        下一次计算准备
        for (int i = startX; i < startX + 3 && i < n; i++) {
            for (int j = startY; j < startY + 3 && j < m; j++) {
                if (matrix[i][j] > 0) {
                    matrix[i][j]--;
                }
            }
        }
        return max;
    }
}
