package com.julyerr.realInterview.exams.pingduoduo.shixi0403;

import java.util.*;

/*
参考大神的解题思路：https://www.nowcoder.com/discuss/71951

需要应用到向量几个性质：
向量平行：x1*y2-x2*y1 = 0
向量垂直：x1*y2+x2*y1 = 0

开始的想法是，直接使用排列组合:Cn3，从所有点中取出3个点，然后减去所有共线的点的组合个数（发现太复杂。。。）；
大神直接暴力求解，将所有不共线3点看成一种情况，然后因为计算多次只需要count/6即可
* */
public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                nodes[i] = new Node(x, y);
            }
            int count = 0;
//            暴力求解
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
//                        不同的三点，不能共线
                        if (i != j && k != i && k != j && !isSameLine(nodes[i], nodes[j], nodes[k])) {
                            count++;
                        }
                    }
                }
            }
//            一个三角形重复计算了6次
            System.out.println(count / 6);
        }
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //    向量判断是否共线
    private static boolean isSameLine(Node node1, Node node2, Node node) {
        return (node1.x - node.x) * (node2.y - node.y) - (node2.x - node.x) * (node1.y - node.y) == 0;
    }
}
