package com.julyerr.realInterview.greedy;

import java.util.Scanner;

/*
 * 开始没有看清楚题目，所画的正方形边必须沿着方格纸线
 * 只需要比较x和y最大差值即可
 * */
public class GridPaper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] numX = new int[n];
            int[] numY = new int[n];
            int minX = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            int minY = Integer.MAX_VALUE;
            int maxY = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                numX[i] = scanner.nextInt();
                minX = Math.min(minX, numX[i]);
                maxX = Math.max(maxX, numX[i]);
                numY[i] = scanner.nextInt();
                minY = Math.min(minY, numY[i]);
                maxY = Math.max(maxY, numY[i]);
            }

            int ret = 0;
            int a = maxX - minX;
            int b = maxY - minY;
            if (a >= b) {
                ret = a * a;
            } else {
                ret = b * b;
            }
            System.out.println(ret);
        }
    }
}
