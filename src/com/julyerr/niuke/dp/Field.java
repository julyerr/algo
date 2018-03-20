package com.julyerr.niuke.dp;

/**
 * 牛牛和 15 个朋友来玩打土豪分田地的游戏，牛牛决定让你来分田地，地主的田地可以看成是一个矩形，
 * 每个位置有一个价值。分割田地的方法是横竖各切三刀，分成 16 份，作为领导干部，
 * 牛牛总是会选择其中总价值最小的一份田地， 作为牛牛最好的朋友，你希望牛牛取得的田地的价值和尽可能大，你知道这个值最大可以是多少吗？
 * 输入描述:
 * 每个输入包含 1 个测试用例。每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 75），
 * 表示田地的大小，接下来的 n 行，每行包含 m 个 0-9 之间的数字，表示每块位置的价值。
 * 输出描述:
 * 输出一行表示牛牛所能取得的最大的价值。
 * 示例1
 * 输入
 * <p>
 * 4 4
 * 3332
 * 3233
 * 3332
 * 2323
 * 输出
 * <p>
 * 2
 */

import java.util.Scanner;

/**
 * 网易出的题目真是，搞不清楚题目的意思
 * 题目意思：
 * 简单理解就是将n*m的矩阵，通过横竖3刀进行划分16份，取出其中最小的一块
 * 但是因为有多种划分的方法（n,m > 4的时候），找出所有划分的情况下的最大值
 * <p>
 * 参考讨论中别人的解题思路实现的
 * <p>
 * 先计算出输入矩阵的sum矩阵
 * 利用二分法针对不同的划分情况进行遍历
 */
public class Field {
    public void field() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String string = scanner.next();
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = string.charAt(j) - '0';
                }
            }

//            为计算的统一性，计算出sum矩阵
            int[][] sum = new int[n + 1][m + 1];
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }

            int left = 0;
            int right = sum[n][m];
            int res = 0;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
//                如果满足情况，增大mid值
                if (fit(mid, sum)) {
                    left = mid + 1;
                    res = mid;
                } else {
                    right = mid - 1;
                }
            }
            System.out.println(res);
        }
    }

    private boolean fit(int least, int[][] sum) {
        int rows = sum.length;
        int cols = sum[0].length;
//        将rows切成4段
        for (int i = 1; i < rows - 3; i++) {
            for (int j = i + 1; j < rows - 2; j++) {
                for (int k = j + 1; k < rows - 1; k++) {
                    int cnt = 0;
                    int last = 0;
//                    针对cols切分
                    for (int l = 1; l < cols; l++) {
                        int s1 = distance(sum, i, l, 0, last);
                        int s2 = distance(sum, j, l, i, last);
                        int s3 = distance(sum, k, l, j, last);
                        int s4 = distance(sum, rows - 1, l, k, last);
//                        如果切分的四大块都大于least，更新last
                        if (s1 >= least && s2 >= least && s3 >= least && s4 >= least) {
                            last = l;
                            cnt++;
                        }
//                        如果划分为4块，返回true
                        if (cnt >= 4) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private int distance(int[][] sum, int i, int j, int x, int y) {
        return sum[x][y] - sum[i][y] - sum[x][j] + sum[i][j];
    }

    public static void main(String[] args) {
        Field field = new Field();
        field.field();
    }
}
