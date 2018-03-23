package com.julyerr.niuke.company.exam1;

import java.util.Scanner;

/*
* 直接使用递归，时间复杂度太高
* */
public class MakeNecklace {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            count = 0;
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            node[] nodes = new node[n];
            for (int i = 0; i < n; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                nodes[i] = new node(a, b);
            }
//            System.out.println("input finished");
            dfs(nodes, m, 0);
            System.out.println(count);
        }
    }

    private static void dfs(node[] nodes, int target, int start) {
        int length = nodes.length;
        if (start >= length) {
            return;
        } else if (start == nodes.length - 1 && (target >= nodes[start].start && target <= nodes[start].end)) {
            count++;
            return;
        }
        for (int i = nodes[start].end; i >= nodes[start].start; i--) {
            int tmp = target - i;
            if (tmp < 0) {
                continue;
            }
            dfs(nodes, tmp, start + 1);
        }
    }

    static class node {
        int start, end;

        public node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
