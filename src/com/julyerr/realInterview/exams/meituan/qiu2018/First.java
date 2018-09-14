package com.julyerr.realInterview.exams.meituan.qiu2018;

/*
#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 1e5 + 5;
vector<int> g[MAX_N];
int n, ans;
void dfs(int x, int f, int d) {
    if (x != 1 && g[x].size() == 1) {
        ans = max(ans, d);
        return;
    }
    for (int i = 0; i < g[x].size(); i++) {
        if (g[x][i] == f) continue;
        dfs(g[x][i], x, d + 1);
    }
}
int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n - 1; i++) {
        int x, y;
        scanf("%d%d", &x, &y);
        g[x].push_back(y);
        g[y].push_back(x);
    }
    ans = 0;
    dfs(1, 0, 0);
    printf("%d\n", 2 * n - 2 - ans);
    return 0;
}

* */
public class First {
}
