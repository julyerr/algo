package com.julyerr.pat.levelone.parttwo;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 参考大神的解题思路：http://blog.5ibc.net/p/143986.html
 * 此解法应该是比较简洁的了
 * */
public class TraverlPlan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int S = scanner.nextInt();
            int D = scanner.nextInt();
            int[][] edge = new int[N][N];
            int[][] costs = new int[N][N];
            int[] dis = new int[N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(costs[i], Integer.MAX_VALUE);
            }
            Arrays.fill(dis, Integer.MAX_VALUE);
            boolean[] visited = new boolean[N];
            int[] pre = new int[N];
            int[] prices = new int[N];
            for (int i = 0; i < N; i++) {
                int s = scanner.nextInt();
                int d = scanner.nextInt();
                int distance = scanner.nextInt();
                int cost = scanner.nextInt();
                edge[s][d] = distance;
                edge[d][s] = distance;
                costs[s][d] = cost;
                costs[d][s] = cost;
            }
//            只是将距离变小，初始化工作可以放到循环中一起进行
            dis[S] = 0;
            while (true) {
                int current = -1;
                int min = Integer.MAX_VALUE;
//               找到最小的距离的一端
                for (int i = 0; i < N; i++) {
                    if (!visited[i] && dis[i] < min) {
                        min = dis[i];
                        current = i;
                    }
                }
//                已经遍历完成
                if (current == -1) {
                    break;
                }
                visited[current] = true;
                for (int i = 0; i < N; i++) {
//                    对于新的节点试图更新距离
                    if (!visited[i] && edge[current][i] != Integer.MAX_VALUE) {
//                        距离变小
                        if (dis[i] > dis[current] + edge[current][i]) {
                            dis[i] = dis[current] + edge[current][i];
//                            设置pre、prices数组值
                            pre[i] = current;
                            prices[i] = prices[current] + costs[current][i];
//                            距离相等，但是花费更小
                        } else if (dis[i] == dis[current] + edge[current][i] && prices[i] > prices[current] + costs[current][i]) {
                            pre[i] = current;
                            prices[i] = prices[current] + costs[current][i];
                        }
                    }
                }
            }
            int[] path = new int[N];
            int index = 0;
            int tmp = pre[D];
//            回溯
            while (tmp != S) {
                path[index++] = tmp;
                tmp = pre[tmp];
            }
            System.out.print(S);
            for (int i = index - 1; i >= 0; i--) {
                System.out.print(" " + path[i]);
            }
            System.out.println(" " + D + " " + dis[D] + " " + prices[D]);
        }
    }
}
