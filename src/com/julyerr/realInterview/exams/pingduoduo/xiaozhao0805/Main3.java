package com.julyerr.realInterview.exams.pingduoduo.xiaozhao0805;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 1];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            dp1[i] = dp2[i] = 1;
        }
        int ansA = 1, ansB = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] <= a[i]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
                if (a[j] >= a[i]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ansA = Math.max(ansA, dp1[i]);
            ansB = Math.max(ansB, dp2[i]);
        }
        System.out.println(Math.min(ansA,ansB));
    }
}

/*
6
1 2 4 3 3 3

5
3 5 2 4 1

#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 55;
int a[MAX_N];
int dp1[MAX_N];
int dp2[MAX_N];
int main() {
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) scanf("%d", &a[i]);
    int ansA = 1, ansB = 1;
    for (int i = 0; i < n; i++) dp1[i] = dp2[i] = 1;
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (a[j] <= a[i]) {
                dp1[i] = max(dp1[i], dp1[j] + 1);
            }
            if (a[j] >= a[i]) {
                dp2[i] = max(dp2[i], dp2[j] + 1);
            }
        }
    }
    for (int i = 0; i < n; i++) ansA = max(ansA, dp1[i]), ansB = max(ansB, dp2[i]);
    printf("%d\n", min(ansA, ansB));
    return 0;
}
* */


