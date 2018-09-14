package com.julyerr.realInterview.exams.toutiao.qiuzhao2018;

import java.util.Scanner;

public class Disanti {
    private static int MAX = 410005;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        int[] f = new int[MAX];
        int[] g = new int[MAX];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < MAX; j++) {
                if (g[j] == -1) continue;
                g[j + a[i]] = Math.max(g[j + a[i]], f[j] + b[i]);
                g[j - a[i]] = Math.max(g[j - a[i]], f[j] + b[i]);
                g[j] = Math.max(g[j], f[j]);
            }
            for (int j = 0; j < MAX; j++){
                f[j] = g[j];
                g[j] = -1;
            }
        }
        System.out.println(f[0]);
    }
}
