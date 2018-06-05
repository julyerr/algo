package com.julyerr.leetcode.dynamic;

public class OutOfBoundaryPaths {
    int count = 0;
    int[][] directs = new int[][]{
            {-1, 0, 1},
            {-1, 0, 1}
    };

    public int findPaths(int m, int n, int N, int i, int j) {
        if (m < 0 || n < 0 || N < 1) {
            return 0;
        }
        int[][] matrix = new int[m][n];
    }

    private void dfs(int[][] matrix, int m, int n, int i, int j, int times) {
        if (times == 0) {
            return;
        }
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (k == l) {
                    continue;
                }
                int tmpI = i + k;
                int tmpJ = j + l;
                if (tmpI < 0 || tmpJ < 0 || tmpI >= m || tmpJ >= n) {
                    count += matrix[i][j];
                } else {
                    matrix[tmpI][tmpJ] = matrix[i][j] + 1;
                }
            }
        }
    }
}
