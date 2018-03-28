package com.julyerr.realInterview.exams.netease.one0327;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 参考大神的解题思路，https://www.nowcoder.com/discuss/70736?type=0&order=0&pos=15&page=1
 * 直接暴力求解，针对每个点在所有矩阵中的次数，返回最大值
 * */
public class Rectange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] x1 = new int[n];
            int[] x2 = new int[n];
            int[] y1 = new int[n];
            int[] y2 = new int[n];
            List<Integer> xx = new ArrayList<>();
            List<Integer> yy = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                x1[i] = scanner.nextInt();
                xx.add(x1[i]);
            }
            for (int i = 0; i < n; i++) {
                y1[i] = scanner.nextInt();
                yy.add(y1[i]);
            }
            for (int i = 0; i < n; i++) {
                x2[i] = scanner.nextInt();
                xx.add(x2[i]);
            }
            for (int i = 0; i < n; i++) {
                y2[i] = scanner.nextInt();
                yy.add(y2[i]);
            }
            int result = 0;
            for (Integer x :
                    xx) {
                for (Integer y :
                        yy) {
                    int cnt = 0;
//                    判断每个点在所有矩阵中出现的的次数
                    for (int i = 0; i < n; i++) {
                        if (x1[i] <= x && y1[i] <= y && x2[i] > x && y2[i] > y) {
                            cnt++;
                        }
                    }
                    result = Math.max(result, cnt);
                }
            }
            System.out.println(result);
        }
    }
}
