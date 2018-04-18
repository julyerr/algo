package com.julyerr.pat.levelone.partone;

import java.util.*;

//思路没有问题，关键是java运行超时
/*
 * 参考https://blog.csdn.net/redy_hello/article/details/75209766
 * 使用红黑树存储提高效率,但是还是超时
 * */
public class Goodness {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int L = scanner.nextInt();
            int H = scanner.nextInt();
            TreeSet<Node> treeSet = new TreeSet<>();

            int count = 0;
            for (int i = 0; i < n; i++) {
                int id = scanner.nextInt();
                int de = scanner.nextInt();
                int cai = scanner.nextInt();
                int type = 0;
                if (de < L || cai < L) {
                    continue;
                }
                count++;
//                分别添加到4中人才中去
                if (de >= H && cai >= H) {
                    type = 0;
                } else if (de >= H) {
                    type = 1;
                } else if (de > cai) {
                    type = 2;
                } else {
                    type = 3;
                }
                Node node = new Node(type, id, de, cai);
                treeSet.add(node);
            }
            System.out.println(count);
            for (Node node :
                    treeSet) {
                System.out.println(node.id + " " + node.de + " " + node.cai);
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int type, id, de, cai;

        public Node(int type, int id, int de, int cai) {
            this.type = type;
            this.id = id;
            this.de = de;
            this.cai = cai;
        }

        @Override
        public int compareTo(Node o) {
//            按照类型升序排列
            if (this.type == o.type) {
                int a = this.de + this.cai;
                int b = o.de + o.cai;
                if (a == b) {
                    if (this.de == o.de) {
//                    总分相同、德育分相同，id升序
                        return this.id - o.id;
                    }
//                总分相同，德育分降序
                    return o.de - this.de;
                }
//            总分降序排序
                return b - a;
            }
            return this.type - o.type;
        }
    }
}