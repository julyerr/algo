package com.julyerr.pat.levelone.parttwo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * 并查集将所有联通的端点连通，然后统计没有连通的数量即可
 * */
public class BattleOverCities {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int K = scanner.nextInt();
            Edge[] edges = new Edge[M];
            for (int i = 0; i < M; i++) {
                edges[i] = new Edge(scanner.nextInt(), scanner.nextInt());
            }

            for (int i = 0; i < K; i++) {
                int point = scanner.nextInt();
                int[] end = new int[N + 1];
                for (int j = 1; j <= N; j++) {
                    end[j] = j;
                }
//                将不包含删除点的边连通起来
                for (int j = 0; j < M; j++) {
                    if (edges[j].start == point || edges[j].end == point) {
                        continue;
                    }
                    int a = findEnd(end, edges[j].start);
                    int b = findEnd(end, edges[j].end);
                    if (a != b) {
                        end[a] = b;
                    }
                }

                Set<Integer> set = new HashSet<>();
                //                针对每个点进行判断
                for (int j = 1; j <= N; j++) {
                    if (j != point) {
                        int node = findEnd(end,j);
                        if(!set.contains(node)){
                            set.add(node);
                        }
                    }
                }
//                除去开始的端点
                System.out.println(set.size() > 0 ? set.size() - 1 : 0);
            }
        }
    }

    private static int findEnd(int[] ends, int p) {
        if (p != ends[p]) {
            ends[p] = findEnd(ends,ends[p]);
        }
        return ends[p];
    }

    private static class Edge {
        int start, end;

        public Edge(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}