package com.julyerr.realInterview.array;

import java.util.Scanner;

/*
 * 开始没有理解题目意思，参考大神的解题思路：https://www.nowcoder.com/questionTerminal/6a219d196df44d3abd82fbadb1a62c3f
 *
 * 其实就是扫面整个矩阵两次，求两次覆盖蘑菇总数最大（扫描一次之后需要删除3*3之内的蘑菇一次）
 * */
public class ScanGlance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int k = scanner.nextInt();

            int[][] matrix = new int[N + 1][M + 1];
            while (k-- > 0) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                matrix[x][y] += 1;
            }
//            第一次扫描
            Pos pos = scan(matrix);
            int out = pos.count;
//           删除最大3*3矩阵中蘑菇一个，如果存在的话
            for (int i = pos.x; i < pos.x + 3; i++) {
                for (int j = pos.y; j < pos.y + 3; j++) {
                    if (matrix[i][j] > 0) {
                        matrix[i][j]--;
                    }
                }
            }

//            第二次扫描
            pos = scan(matrix);

            System.out.println(out + pos.count);
        }
    }

    //    统计3*3中最大蘑菇数
    private static Pos scan(int[][] matrix) {
        Pos pos = new Pos();
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[0].length - 2; j++) {

                int count = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (matrix[k][l] > 0) {
                            count++;
                        }
                    }
                }
                if (count > pos.count) {
                    pos.count = count;
                    pos.x = i;
                    pos.y = j;
                }
            }
        }
        return pos;
    }

    //    为方便传递信息
    private static class Pos {
        int count, x, y;
    }

}
