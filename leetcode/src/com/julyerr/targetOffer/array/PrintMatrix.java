package com.julyerr.targetOffer.array;


import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> rt = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length==0) {
            return rt;
        }
        int xLen = matrix[0].length;
        int yLen = matrix.length;
        int x, y;
        x = y = 0;
        while (xLen - 2 * x >= 1 && yLen - 2 * y >= 1) {
            matrixLayer(rt, matrix, x, y, xLen - 1 - x, yLen - 1 - y);
            x++;
            y++;
        }
        return rt;
    }

    private void matrixLayer(List<Integer> list, int[][] matrix, int x, int y, int xMax, int yMax) {
        for (int i = x; i <= xMax; i++) {
            list.add(matrix[y][i]);
        }
        for (int i = y + 1; i < yMax; i++) {
            list.add(matrix[i][xMax]);
        }
        if(yMax > y){
            for (int i = xMax; i >= x; i--) {
                list.add(matrix[yMax][i]);
            }
        }
        if(xMax > x){
            for (int i = yMax-1; i > y; i--) {
                list.add(matrix[i][x]);
            }
        }
    }
    public static void main(String[] args){
        PrintMatrix printMatrix = new PrintMatrix();
//        int[][] matrix = new int[][]{
//                {1,2,3,4},
////                {5,6,7,8},
////                {9,10,11,12},
////                {13,14,15,16}
//        };
        int[][] matrix = new int[][]{
                {1},
                {2},
                {3},
                {4},
        };
        for (Integer integer :
                printMatrix.printMatrix(matrix)) {
            System.out.print(integer+" ");
        }
        System.out.println();
    }
}
