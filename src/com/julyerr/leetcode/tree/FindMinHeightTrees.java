package com.julyerr.leetcode.tree;

import java.util.*;

/*
 * 通过节点的度控制遍历的节点不断往中心逼近，主要参考
 * https://shineboy2013.github.io/2017/12/04/lee-310/
 * */
public class FindMinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> rt = new ArrayList<>();
        if (n < 2) {
            return rt;
        }
        int[] degrees = new int[n];
        List<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }

        for (int[] edge :
                edges) {
            degrees[edge[0]]++;
            degrees[edge[1]]++;
            lists.get(edge[0]).add(edge[1]);
            lists.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 1) {
                queue.add(i);
            }
        }
        rt = new ArrayList<>(queue);
        Queue<Integer> tmp = new LinkedList<>();
        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (Integer neibor :
                    lists.get(i)) {
                if (--degrees[neibor] == 1) {
                    tmp.add(neibor);
                }
            }
            if (queue.isEmpty() && !tmp.isEmpty()) {
                queue = tmp;
                tmp = new LinkedList<>();
                rt = new ArrayList<>(queue);
            }
        }
        return rt;
    }
}
