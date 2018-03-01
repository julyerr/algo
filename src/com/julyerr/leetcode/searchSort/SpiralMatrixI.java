package com.julyerr.leetcode.searchSort;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixI {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rt = new ArrayList<>();
        //        check validation
        if (matrix == null || matrix.length == 0 ||  matrix[0] == null || matrix[0].length == 0) {
            return rt;
        }

//        设置循环边界条件
        int xStart = 0;
        int xEnd = matrix.length - 1;
        int yStart = 0;
        int yEnd = matrix[0].length - 1;

        while (xStart <= xEnd && yStart <= yEnd) {
//            上面一行
            for (int i = yStart; i <= yEnd; i++) {
                rt.add(matrix[xStart][i]);
            }
//            右边一行
            for (int i = xStart + 1; i < xEnd; i++) {
                rt.add(matrix[i][yEnd]);
            }

//            遍历完成
            if (xStart == xEnd || yStart == yEnd) {
                break;
            }
            //            下面一行
            for (int i = yEnd; i >= yStart; i--) {
                rt.add(matrix[xEnd][i]);
            }
//            左边一行
            for (int i = xEnd - 1; i > xStart; i--) {
                rt.add(matrix[i][xStart]);
            }

            xStart++;
            xEnd--;
            yStart++;
            yEnd--;
        }
        return rt;
    }
}
