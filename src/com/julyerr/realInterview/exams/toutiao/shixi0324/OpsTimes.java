package com.julyerr.realInterview.exams.toutiao.shixi0324;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 参考大神的解题思路：https://blog.csdn.net/flushhip/article/details/79685488
 * 使用广搜的方式解题:s,m,cnt
 * 将两种情况的节点都添加到情况中判断：(s+s,s,cnt+1)和(s+m,m,cnt+1)
 * */
public class OpsTimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(1, 1, 0));
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.s == n) {
                    System.out.println(node.cnt);
                    break;
                }
                if (node.s + node.s <= n) {
                    queue.add(new Node(node.s + node.s, node.s, node.cnt + 1));
                }
                if (node.s + node.m <= n) {
                    queue.add(new Node(node.s + node.m, node.m, node.cnt + 1));
                }
            }
        }
    }

    private static class Node {
        int s, m, cnt;

        public Node(int s, int m, int cnt) {
            this.s = s;
            this.m = m;
            this.cnt = cnt;
        }
    }
}
