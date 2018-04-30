package com.julyerr.leetcode.dynamic;

import java.util.Arrays;
import java.util.Comparator;

public class DollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null) {
            return 0;
        }
        if (envelopes.length < 2) {
            return envelopes.length;
        }
        Node[] nodes = new Node[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            nodes[i] = new Node(envelopes[i][0], envelopes[i][1]);
        }
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
//                为了减少比较次数，使用降序的方式进行
                if (o1.first == o2.first) {
                    return o2.second - o1.second;
                }
                return o1.first - o2.first;
            }
        });
        int[] dp = new int[nodes.length];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < nodes.length; i++) {
            int tmp = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (j + 1 < tmp - 1) {
                    break;
                }
                if (nodes[j].second < nodes[i].second) {
                    tmp = Math.max(dp[j] + 1, tmp);
                }
            }
            dp[i] = tmp;
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    private static class Node {
        int first, second;

        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        DollEnvelopes dollEnvelopes = new DollEnvelopes();
        int[][] matrix = new int[][]{
                {5, 4}, {6, 4}, {6, 7}, {2, 3}
        };
        System.out.println(dollEnvelopes.maxEnvelopes(matrix));
    }
}
