package com.julyerr.pat.levelone.parttwo;

import java.util.Arrays;
import java.util.Scanner;

public class Rescue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int S = scanner.nextInt();
            int D = scanner.nextInt();
            int[] hos = new int[N];
            for (int i = 0; i < N; i++) {
                hos[i] = scanner.nextInt();
            }
            int[][] edge = new int[N][N];
            int[] dis = new int[N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(edge[i], Integer.MAX_VALUE);
            }
            Arrays.fill(dis, Integer.MAX_VALUE);
            boolean[] visited = new boolean[N];
            for (int i = 0; i < M; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int distance = scanner.nextInt();
                edge[a][b] = distance;
                edge[b][a] = distance;
            }

            int[] ways = new int[N];
            int[] costs = new int[N];

//            初始化
            dis[S] = 0;
            ways[S] = 1;
            costs[S] = hos[S];
            while (true) {
                int current = -1;
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < N; i++) {
                    if (!visited[i] && dis[i] < min) {
                        min = dis[i];
                        current = i;
                    }
                }

                if (current == -1) {
                    break;
                }
                visited[current] = true;
                for (int i = 0; i < N; i++) {
                    if (!visited[i] && edge[current][i] != Integer.MAX_VALUE) {
                        if (dis[i] > dis[current] + edge[current][i]) {
                            dis[i] = dis[current] + edge[current][i];
//                            方法数
                            ways[i] = ways[current];
//                            人员数
                            costs[i] = hos[i] + costs[current];
                        } else if (dis[i] == dis[current] + edge[current][i]) {
                            ways[i] += ways[current];
                            costs[i] = Math.max(costs[i], costs[current] + hos[i]);
                        }
                    }
                }
            }
            System.out.println(ways[D] + " " + costs[D]);
        }
    }
}
