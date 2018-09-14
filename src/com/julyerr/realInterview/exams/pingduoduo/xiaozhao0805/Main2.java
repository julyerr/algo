package com.julyerr.realInterview.exams.pingduoduo.xiaozhao0805;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[n][n];
//        初始化矩阵
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] strings = line.split(" ");
            for (int j = 0; j < strings.length; j++) {
                matrix[i][Integer.parseInt(strings[j])] = 1;
            }
        }
        int ans = 0, pos = -1;
        for (int i = 0; i < n; i++) {
//            不是好友关系
            if (x == i || matrix[x][i] == 1) {
                continue;
            }
            int sum = 0;
//            如果是共同的好友的话
            for (int j = 0; j < n; j++) {
                if (matrix[x][j] != 0 && matrix[i][j] != 0) {
                    sum++;
                }
            }
            if (sum > ans) {
                ans = sum;
                pos = i;
            }
        }
        System.out.println(pos);
    }
}

/*
5 0
1 2 3
0 4
0 4
0 4
1 2 3

#include <bits/stdc++.h>
using namespace std;
const int MAX_BUF = 1e6+5;
const int MAX_N = 105;
int f[MAX_N][MAX_N];
char buf[MAX_BUF];
int main() {
    gets(buf);
    int n, x;
    sscanf(buf, "%d%d", &n, &x);
    for (int i = 0; i < n; i++) {
        gets(buf);
        int y = -1;
        int len = strlen(buf);
        for (int j = 0; j < len; j++) {
            if (buf[j] == ' ') {
                if (y != -1) {
                    f[i][y] = 1;
                    y = -1;
                }
                continue;
            }
            if (y == -1) y = buf[j] - '0';
            else y = y * 10 + buf[j] - '0';
        }
        if (y != -1) {
            f[i][y] = 1;
        }
    }
    int ans = 0, pos = -1;
    for (int i = 0; i < n; i++) {
        if (x == i) continue;
        if (f[x][i]) continue;
        int sum = 0;
        for (int j = 0; j < MAX_N; j++) if (f[x][j] && f[i][j]) sum++;
        if (sum > ans) {
            ans = sum;
            pos = i;
        }
    }
    printf("%d\n", pos);
    return 0;
}
 * */