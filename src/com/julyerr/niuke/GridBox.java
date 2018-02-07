package com.julyerr.niuke;

import java.util.Scanner;

/**
 * 题目描述
 * 二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
 * 对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
 * ( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根
 * 小易想知道最多可以放多少块蛋糕在网格盒子里。
 * 输入描述:
 * 每组数组包含网格长宽W,H，用空格分割.(1 ≤ W、H ≤ 1000)
 * 输出描述:
 * 输出一个最多可以放的蛋糕数
 * 示例1
 * 输入
 * <p>
 * 3 2
 * 输出
 * <p>
 * 4
 */

/**
 * 设置一个矩阵，dis1^2 + dis2 ^ 2 = 4的情况，只有x或者y相差2才满足条件
 */
public class GridBox {
    public static void main(String[] args) {
        GridBox gridBox = new GridBox();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int w = scanner.nextInt();
            int h = scanner.nextInt();
            System.out.println(gridBox.gridBox(h, w));
        }
    }

    public int gridBox(int m, int n) {
        int ret = 0;
        boolean[][] matrix = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!matrix[i][j]) {
                    ret++;
                    matrix[i][j] = true;
                    if (i + 2 < m) {
                        matrix[i + 2][j] = true;
                    }
                    if (j + 2 < n) {
                        matrix[i][j + 2] = true;
                    }
                }
            }
        }
        return ret;
    }
}
