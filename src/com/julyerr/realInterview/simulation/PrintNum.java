package com.julyerr.realInterview.simulation;

public class PrintNum {
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        int total = n * m;
        int[] nums = new int[total];
        int xLen = n - 1;
        int yLen = m - 1;
        int xStart = 0;
        int yStart = 0;
        int index = 0;
        while (xLen >= xStart && yLen >= yStart) {
            for (int i = yStart; i <= yLen; i++) {
                nums[index++] = mat[xStart][i];
            }
            for (int i = xStart + 1; i <= xLen; i++) {
                nums[index++] = mat[i][yLen];
            }
            if (yLen != yStart && xStart != xLen) {
                for (int i = yLen - 1; i >= yStart; i--) {
                    nums[index++] = mat[xLen][i];
                }
                for (int i = xLen - 1; i > xStart; i--) {
                    nums[index++] = mat[i][yStart];
                }
            }
            xStart++;
            xLen--;
            yStart++;
            yLen--;
        }
        return nums;
    }

    public static void main(String[] args) {
        PrintNum printNum = new PrintNum();
        int[][] matrix = new int[][]{
                {1},
//                {3,4}
        };
        int[] nums = printNum.clockwisePrint(matrix, matrix.length, matrix[0].length);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
