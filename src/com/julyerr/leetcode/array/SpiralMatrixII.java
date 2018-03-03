package com.julyerr.leetcode.array;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
//        check validation
        if (n < 1) {
            return new int[][]{};
        }

        int[][] ret = new int[n][n];
        int startX = 0;
        int startY = 0;
        int endX = n - 1;
        int endY = n - 1;
        int index = 1;
        while (startX <= endX && startY <= endY) {
//            最上面一行
            for (int i = startY; i <= endY; i++) {
                ret[startX][i] = index++;
            }
//            最右面一行
            for (int i = startX + 1; i <= endX; i++) {
                ret[i][endY] = index++;
            }
//            是否可以结束循环
            if (startX == endX || startY == endY) {
                break;
            }
//            最下面一行
            for (int i = endY - 1; i >= startY; i--) {
                ret[endX][i] = index++;
            }
//            最左面一行
            for (int i = endX - 1; i > startX; i--) {
                ret[i][startY] = index++;
            }
            startX++;
            startY++;
            endX--;
            endY--;
        }
        return ret;
    }
}
