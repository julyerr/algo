package com.julyerr.leetcode.moni;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length - 1;
        int col = 0;
        while (col < matrix[0].length && row >= 0) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target > matrix[row][col]) {
                col++;
            } else {
                row--;
            }
        }
        return false;
    }
}
