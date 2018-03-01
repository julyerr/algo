package com.julyerr.leetcode.array;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
//        check validation
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean xFlag, yFlag;
        xFlag = yFlag = false;

//        对第一行、第一列设置标志位
        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) {
                yFlag = true;
                break;
            }
        }

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                xFlag = true;
                break;
            }
        }


//        设置矩阵中其他元素标志位
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

//        除了首行、首列之外的置零操作
        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < rows; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

//        首行、首列的置零操作
        if (yFlag) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }

        if (xFlag) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
