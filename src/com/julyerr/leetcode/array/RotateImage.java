package com.julyerr.leetcode.array;

public class RotateImage {
    public void rotate(int[][] matrix) {
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
        RotateImage rotateImage = new RotateImage();
        int[][] images = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotateImage.rotate(images);
        System.out.println("final");
        for (int i = 0; i < images.length; i++) {
            for (int j = 0; j < images[0].length; j++) {
                System.out.print(images[i][j] + " ");
            }
            System.out.println();
        }
    }
}
