package com.julyerr.realInterview.exams.pingduoduo.xiaozhao0805;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int ans = 0;

//        类似切绳子的思路
        for (int i = 1; i < input.length(); i++) {
            String a = input.substring(0, i);
            String b = input.substring(i);
            ans += dfs(a) * dfs(b);
        }
        System.out.println(ans);
    }

    private static int dfs(String string) {
        int len = string.length();
        if (len == 1) {
            return 1;
        }
//        只能是整数
        if (string.charAt(len - 1) == '0') {
            if (string.charAt(0) == '0') {
                return 0;
            }
            return 1;
        }
//        只能是小数
        if (string.charAt(0) == '0') {
            return 1;
        }
        return len;
    }
}


/*
00011
123

#include <bits/stdc++.h>
using namespace std;
const int MAX_S = 15;
char s[MAX_S], a[MAX_S], b[MAX_S];
int judge(char *str) {
    int len = strlen(str);
    if (len == 1) {
        return 1;
    }
    if (str[len - 1] == '0') {
        if (str[0] == '0') return 0;
        return 1;
    }
    if (str[0] == '0') return 1;
    return len;
}
int main() {
    scanf("%s", s);
    int len = strlen(s);
    int ans = 0;
    for (int i = 1; i <= len - 1; i++) {
        int idxA = 0, idxB = 0;
        for (int j = 0; j < i; j++) a[idxA++] = s[j]; a[idxA] = '\0';
        for (int j = i; j < len; j++) b[idxB++] = s[j]; b[idxB] = '\0';
        int ansA = judge(a);
        int ansB = judge(b);
        ans += ansA * ansB;
    }
    printf("%d\n", ans);
    return 0;
}
* */