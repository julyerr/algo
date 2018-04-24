package com.julyerr.pat.levelone.parttwo;

import java.util.Scanner;

public class APlusB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Node[] nodes = new Node[1001];
            int n = scanner.nextInt();
            int count = 0;
            int maxIndex = -1;
            for (int i = 0; i < n; i++) {
                int e = scanner.nextInt();
                double xishu = scanner.nextDouble();
                nodes[e] = new Node(e, xishu);
                count++;
                if (maxIndex < e) {
                    maxIndex = e;
                }
            }
            n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int e = scanner.nextInt();
                double xishu = scanner.nextDouble();
                if (nodes[e] == null) {
                    nodes[e] = new Node(e, xishu);
                    count++;
                } else {
                    nodes[e].xishu += xishu;
                    if(Math.abs(nodes[e].xishu-0)<1e-7){
                        count--;
                        nodes[e] = null;
                        if(maxIndex==e){
                            maxIndex = -1;
                            continue;
                        }
                    }
                }
                if (maxIndex < e) {
                    maxIndex = e;
                }
            }
            System.out.printf("%d %d %.1f", count, maxIndex, nodes[maxIndex].xishu);
            for (int i = maxIndex - 1; i >= 0; i--) {
                if (nodes[i] != null) {
                    System.out.printf(" %d %.1f", i, nodes[i].xishu);
                }
            }
            System.out.println();
        }
    }

    private static class Node {
        int e;
        double xishu;

        public Node(int e, double xishu) {
            this.e = e;
            this.xishu = xishu;
        }
    }
}
