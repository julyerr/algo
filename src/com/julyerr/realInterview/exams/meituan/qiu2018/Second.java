package com.julyerr.realInterview.exams.meituan.qiu2018;

import java.util.Scanner;
/*
*
#include <bits/stdc++.h>
using namespace std;
#define lsub l, m, rt << 1
#define rsub m + 1, r, rt << 1 | 1
#define lson rt << 1
#define rson rt << 1 | 1
const int MAX_N = 1e5 + 5;
const int N = 1e5;
int a[MAX_N];
int tree[MAX_N * 4];
void add(int pos, int v, int l, int r, int rt) {
    if (l == r) {
        tree[rt] += v;
        return;
    }
    int m = (l + r) >> 1;
    if (pos <= m) add(pos, v, lsub);
    else add(pos, v, rsub);
    tree[rt] = max(tree[lson], tree[rson]);
}
int query(int x, int y, int l, int r, int rt) {
    if (x <= l && r <= y) {
        return tree[rt];
    }
    int m = (l + r) >> 1;
    int ans = 0;
    if (x <= m) ans = max(ans, query(x, y, lsub));
    if (m < y) ans = max(ans, query(x, y, rsub));
    return ans;
}
int main() {
    int n, k, t;
    scanf("%d%d%d", &n, &k, &t);
    for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
    if (k > n) {
        printf("0\n");
        return 0;
    }
    int ans = 0;
    int l = 1, r = k, cnt = 0;
    for (int i = l; i <= r; i++) add(a[i], 1, 1, N, 1);
    cnt = query(1, N, 1, N, 1);
    while (r < n) {
        cnt = 0;
        add(a[l], -1, 1, N, 1);
        l++;
        r++;
        add(a[r], 1, 1, N, 1);
        cnt = max(cnt, query(1, N, 1, N, 1));
        if (cnt >= t) ans++;
    }
    printf("%d\n", ans);
    return 0;
}

* */
public class Second {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int t = scanner.nextInt();
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        if(k>n){
            System.out.println(0);
            return;
        }
        int ans = 0;
        int l = 1,r = k,cnt = 0;
        int[] visited = new int[n+1];
        for (int i = l; i <= r; i++) {
            visited[a[i]]++;
            cnt = Math.max(cnt,visited[a[i]]);
        }
        if(cnt >= t){
            ans++;
        }
        while (r < n){
            visited[a[l]]--;
            l++;
            r++;
            visited[a[r]]++;
            cnt = Math.max(cnt,visited[a[r]]);
            if(cnt>=r){
                ans++;
            }
        }
        System.out.println(ans);

    }
}
