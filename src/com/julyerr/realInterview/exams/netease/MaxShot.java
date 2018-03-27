package com.julyerr.realInterview.exams.netease;

import java.util.Scanner;

/*
 * 参考大神的解题思路：https://www.nowcoder.com/questionTerminal/d3f26db0325444078717cc802e0056d8
 *
 * 使用四次循环，分别用于挑选不同的四个点；
 * 第一次和第二次循环挑选好为x轴的直线，第三次和第四次用于挑选好y轴；
 * 然后在整个遍历的过程中选择最大的值
 * */
public class MaxShot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
//            录入所有点的坐标值
            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                y[i] = scanner.nextInt();
            }

            int maxShot = 0;
            if (n < 4) {
                maxShot = n;
            } else {
//                            确定x轴
                for (int i = 0; i < n - 1; i++) {
                    for (int j = i + 1; j < n; j++) {
                        int x1 = x[j] - x[i];
                        int y1 = y[j] - y[i];
                        for (int k = 0; k < n; k++) {
//                            确定y轴的一个点
                            if (k == i || k == j) {
                                continue;
                            }
                            int tmp = 3;
//                            变换另一个点
                            for (int l = 0; l < n; l++) {
                                if (l == i || l == j || l == k) {
                                    continue;
                                }
                                int x2 = x[l] - x[i];
                                int y2 = y[l] - y[i];
                                int x3 = x[l] - x[k];
                                int y3 = y[l] - y[k];
//                                该点在x轴或者y轴上添加进来
                                if (x1 * y2 == x2 * y1 || x1 * x3 + y1 * y3 == 0) {
                                    tmp++;
                                }
                                maxShot = Math.max(maxShot, tmp);
                            }
                        }
                    }
                }
            }
            System.out.println(maxShot);
        }
    }
}
