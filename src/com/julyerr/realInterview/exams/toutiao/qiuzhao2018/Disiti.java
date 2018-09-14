package com.julyerr.realInterview.exams.toutiao.qiuzhao2018;

import java.util.Scanner;

public class Disiti {
    private static int[] logn;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        logn = new int[n+1];
        int[][] fa = new int[n+1][n+1];
        int[][] fb = new int[n+1][n+1];
        for (int i = 2; i <= n; i++){
            logn[i] = logn[i >> 1] + 1;
        }
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = scanner.nextInt();
        }

        consA(a, fa,n);
        consB(b, fb,n);
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] >= b[i]) continue;
            int left = i;
            int right = n;
            int t = i;
            while (left <= right) {
                int mid = (left + right) >>1;
                if (judgeA(i, mid, fa) >= askB(i, mid, fb)) {
                    right = mid - 1;
                } else {
                    t = mid;
                    left = mid + 1;
                }
            }
            ans += t - i + 1;
        }
        System.out.println(ans);
    }

    private static int judgeA(int x, int y, int[][] fa) {
        int k = logn[y - x + 1];
        return Math.max(fa[k][x], fa[k][y - (1 << k) + 1]);
    }
    private static void consA(int a[], int[][] fa, int n) {
        for (int i = 1; i <= n; i++) fa[0][i] = a[i];
        for (int j = 1; j <= logn[n]; j++) {
            for (int i = 1; i + (1 << j) - 1 <= n; i++) {
                fa[j][i] = Math.max(fa[j - 1][i], fa[j - 1][i + (1 << (j - 1))]);
            }
        }
    }
    private static  int askB(int x, int y, int[][] fb) {
        int k = logn[y - x + 1];
        return Math.min(fb[k][x], fb[k][y - (1 << k) + 1]);
    }
    private static  void consB(int b[], int[][] fb, int n) {
        for (int i = 1; i <= n; i++) fb[0][i] = b[i];
        for (int j = 1; j <= logn[n]; j++) {
            for (int i = 1; i + (1 << j) - 1 <= n; i++) {
                fb[j][i] = Math.min(fb[j - 1][i], fb[j - 1][i + (1 << (j - 1))]);
            }
        }
    }
}
