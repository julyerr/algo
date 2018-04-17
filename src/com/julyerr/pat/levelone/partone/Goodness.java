package com.julyerr.pat.levelone.partone;

import java.util.*;

public class Goodness {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int L = scanner.nextInt();
            int H = scanner.nextInt();
            List<List<Node>> all = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                all.add(new ArrayList<>());
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                int id = scanner.nextInt();
                int de = scanner.nextInt();
                int cai = scanner.nextInt();
                if (de < L || cai < L) {
                    continue;
                }
                count++;
                Node node = new Node(id, de, cai);
                if (de >= H && cai >= H) {
                    all.get(0).add(node);
                } else if (de >= H) {
                    all.get(1).add(node);
                } else if (de > cai) {
                    all.get(2).add(node);
                } else {
                    all.get(3).add(node);
                }
            }
            System.out.println(count);
            for (int i = 0; i < 4; i++) {
                List<Node> cur = all.get(i);
                Collections.sort(cur);
                for (int j = 0; j < cur.size(); j++) {
                    Node node = cur.get(j);
                    System.out.println(node.id + " " + node.de + " " + node.cai);
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int id, de, cai;

        public Node(int id, int de, int cai) {
            this.id = id;
            this.de = de;
            this.cai = cai;
        }

        @Override
        public int compareTo(Node o) {
            int a = this.de + this.cai;
            int b = o.de + o.cai;
            if (a == b) {
                if (this.de == o.de) {
                    return this.id-o.id;
                }
                return o.de - this.de;
            }
            return b - a;
        }
    }
}