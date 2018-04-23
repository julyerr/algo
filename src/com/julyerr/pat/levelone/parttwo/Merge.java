package com.julyerr.pat.levelone.parttwo;

import java.util.Scanner;

/*
 * 采用归并方式的排序，但是还是有部分测试用例会超时
 * */
public class Merge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] pre = new int[n];
            for (int i = 0; i < n; i++) {
                pre[i] = scanner.nextInt();
            }
            int m = scanner.nextInt();
            int[] next = new int[m];
            for (int i = 0; i < m; i++) {
                next[i] = scanner.nextInt();
            }
            int mid = (n + m) >> 1;
            int index = 0;
            int tmp = 0;

            int i = 0, j = 0;
            while (i < n && j < m) {
                if (pre[i] < next[j]) {
                    tmp = pre[i++];
                } else {
                    tmp = next[j++];
                }
                index++;
                if (index == mid) {
                    break;
                }
            }
            while (index < mid && i < n) {
                index++;
                tmp = pre[i++];
            }
            while (index < mid && j < m) {
                index++;
                tmp = next[j++];
            }
            System.out.println(tmp);
        }
    }
}
