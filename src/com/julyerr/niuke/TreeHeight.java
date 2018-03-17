package com.julyerr.niuke;

import java.util.Scanner;

/*
 * 开始直接通过开始节点是否存在统计次数出现错误
 * 通过建立类似二叉树结构求解高度,测试用例好像有点问题，具体参见注释
 * */

public class TreeHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            node[] nodes = new node[n];
            for (int i = 0; i < n - 1; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if (nodes[start] == null) {
                    nodes[start] = new node(start);
                }
                if (nodes[end] == null) {
                    nodes[end] = new node(end);
                }
                if (nodes[start].left == null) {
                    nodes[start].left = nodes[end];
//                   同样要进行判断，不然测试用例只能通过20%
                } else if (nodes[end].right == null) {
                    nodes[start].right = nodes[end];
                }
            }
            System.out.println(maxHeight(nodes[0]));
        }
    }

    //    建立节点结构
    static class node {
        node left, right;
        int val;

        public node(int data) {
            this.val = data;
        }
    }

    private static int maxHeight(node node) {
        if (node == null) {
            return 0;
        }
        int left = maxHeight(node.left);
        int end = maxHeight(node.right);

        return Math.max(left, end) + 1;
    }
}
