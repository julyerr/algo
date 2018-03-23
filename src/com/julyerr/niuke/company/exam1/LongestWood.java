package com.julyerr.niuke.company.exam1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
* 最后一个测试用例没有通过
* */
public class LongestWood {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            node[] nodes = new node[m];
            for (int i = 0; i < m; i++) {
                int start = scanner.nextInt() - 1;
                int end = scanner.nextInt() - 1;
                int distance = scanner.nextInt();
                nodes[i] = new node(start, end, distance);
            }
            Arrays.sort(nodes, new Comparator<node>() {
                @Override
                public int compare(node o1, node o2) {
                    return o1.distance - o2.distance;
                }
            });
            int max = Integer.MIN_VALUE;
            int[] ends = new int[n];
            for (int i = 0; i < m; i++) {
                int start = getEnd(ends, nodes[i].start);
                int end = getEnd(ends, nodes[i].end);
                if (start != end) {
                    ends[end] = start;
                    if (max < nodes[i].distance) {
                        max = nodes[i].distance;
                    }
                }
            }
            System.out.println(max);
        }
    }

    public static int getEnd(int[] ends, int index) {
        while (ends[index] != 0) {
            index = ends[index];
        }
        return index;
    }

    public static class node {
        int start, end, distance;

        public node(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
}
