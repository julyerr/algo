package com.julyerr.pat.levelone.partone;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MoonCake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();
            Node[] nodes = new Node[N];
            for (int i = 0; i < N; i++) {
                nodes[i] = new Node();
                nodes[i].num = scanner.nextInt();
            }
            for (int i = 0; i < N; i++) {
                nodes[i].price = scanner.nextInt();
            }
            Arrays.sort(nodes, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    double tmp = 1.0 * o2.price / o2.num - 1.0 * o1.price / o1.num;
                    if (tmp > 1e-8) {
                        return 1;
                    }
                    return -1;
                }
            });
            double sum = 0;
            for (int i = 0; i < N; i++) {
                if (D > nodes[i].num) {
                    sum += nodes[i].price;
                    D -= nodes[i].num;
                } else {
                    sum += nodes[i].price * 1.0 * D / nodes[i].num;
                    break;
                }
            }
            System.out.printf("%.2f\n", sum);
        }
    }

    private static class Node {
        int num, price;
    }
}
