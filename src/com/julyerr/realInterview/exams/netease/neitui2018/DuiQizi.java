package com.julyerr.realInterview.exams.netease.neitui2018;

import java.util.Arrays;
import java.util.Scanner;

/*
* 参考大神的解题思路:https://www.nowcoder.com/questionTerminal/27f3672f17f94a289f3de86b69f8a25b
*
* 所有棋子可能落在位置只能从x[i],y[j]中选择，然后针对所有的情况暴力求解
* */
public class DuiQizi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                y[i] = scanner.nextInt();
            }

            long[] minDis = new long[n];
            Arrays.fill(minDis, Long.MAX_VALUE);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    long[] tmp = new long[n];
                    for (int k = 0; k < n; k++) {
//                        记录每一棋子移动的步数
                        tmp[k] = Math.abs(x[i] - x[k]) + Math.abs(y[j] - y[k]);
                    }
//                    排序
                    Arrays.sort(tmp);
                    long tmpSum = 0;
//                    统计1-n个棋子，分别移动到一起的最小步数总和
                    for (int k = 0; k < n; k++) {
                        tmpSum += tmp[k];
                        minDis[k] = Math.min(tmpSum, minDis[k]);
                    }
                }
            }
            for (int i = 0; i < n - 1; i++) {
                System.out.print(minDis[i] + " ");
            }
            System.out.println(minDis[n - 1]);
        }
    }
}
