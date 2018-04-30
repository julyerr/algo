package com.julyerr.leetcode.dynamic;

public class NumMatrix {
    private int[][] matrix;
    private int[][] sum;
    boolean validate;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
            validate = false;
            return;
        }
        validate = true;
//        预留多余的空间利于计算
        sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] + matrix[i][j] - sum[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (!validate) {
            return 0;
        }
        if (row1 > matrix.length || col1 > matrix[0].length || row2 > matrix.length || col2 > matrix[0].length) {
            return 0;
        }
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    }
}
