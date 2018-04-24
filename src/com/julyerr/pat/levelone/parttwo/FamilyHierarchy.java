package com.julyerr.pat.levelone.parttwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 此题比较巧妙的方式，没有建立结构，只是简单的统计非叶子节点的个数
 * */
public class FamilyHierarchy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            Node[] nodes = new Node[N + 1];
            nodes[1] = new Node(1, 1);
            int maxLevel = 1;
            for (int i = 0; i < M; i++) {
                int id = scanner.nextInt();
                int k = scanner.nextInt();
                nodes[id].isLeaf = false;
                maxLevel = Math.max(maxLevel, nodes[k].level + 1);
                for (int j = 0; j < k; j++) {
                    int idTMp = scanner.nextInt();
                    nodes[idTMp] = new Node(idTMp, nodes[id].level + 1);
                }
            }
            int[] count = new int[maxLevel + 1];
            for (int i = 1; i <= N; i++) {
                if (nodes[i].isLeaf) {
                    count[nodes[i].level]++;
                }
            }
            System.out.print(count[1]);
            for (int i = 2; i <= maxLevel; i++) {
                System.out.print(" " + count[i]);
            }
            System.out.println();
        }
    }

    private static class Node {
        int id, level;
        boolean isLeaf;

        public Node(int id, int level) {
            this.id = id;
            this.level = level;
            isLeaf = true;
        }
    }
}
