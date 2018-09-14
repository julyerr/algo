package com.julyerr.leetcode.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * 参考思路：https://blog.csdn.net/jly0612/article/details/52416568
 * */

public class LexicalOrder {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> rt = new LinkedList<>();
        if (n < 1) {
            return rt;
        }
        for (int i = 1; i < 10; i++) {
            dfs(n, i, rt);
        }
        return rt;
    }

    private void dfs(int n, int cur, List<Integer> rt) {
        if (cur > n) {
            return;
        }
        rt.add(cur);
        cur *= 10;
        for (int i = 0; i < 10; i++) {
            dfs(n, cur + i, rt);
        }
    }

    public static void main(String[] args){
        System.out.println(new LexicalOrder().lexicalOrder(13));
    }
}
