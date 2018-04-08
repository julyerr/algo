package com.julyerr.realInterview.exams.baidu.chunzhao2017;

import java.util.*;

/*
5
R 0 0 0
R 0 4 0
R 0 0 3
G 92 14 7
G 12 16 8

输出例子1:
6.00000


5
R 0 0 0
R 0 4 0
R 0 0 3
G 0 5 0
B 0 0 12

对应输出应该为:

30.00000
* */

/*
* 主要是考察一些数学公式和编程能力
* 二维向量三角形的面积计算： http://yiyunscu.blog.163.com/blog/static/362633202009421113419632/
*   S = (x1*y2-x2*y1)/2;
*  三维的话，海伦公式：https://blog.csdn.net/hjq376247328/article/details/49465137
*   half = (a+b+c)/2;
*   S = sqrt(abs(half*(a-half)*(b-half)*(c-half)));
* */
public class MaxTrangle {

    public static void main(String[] args) {
        Map<String, Character> map = new HashMap<>();
        map.put("R", 'R');
        map.put("G", 'G');
        map.put("B", 'B');
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            List<List<Node>> nodes = new ArrayList<>();
            List<Node> redNodes = new ArrayList<>();
            List<Node> greenNodes = new ArrayList<>();
            List<Node> blueNodes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char c = map.get(scanner.next());
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int z = scanner.nextInt();
                Node tmp = new Node(c, x, y, z);
                if (c == 'R') {
                    redNodes.add(tmp);
                } else if (c == 'G') {
                    greenNodes.add(tmp);
                } else {
                    blueNodes.add(tmp);
                }
            }

//            是否拥有三种颜色可选
            boolean flag = true;
            if (redNodes.isEmpty() || greenNodes.isEmpty() || blueNodes.isEmpty()) {
                flag = false;
            }
            nodes.add(redNodes);
            nodes.add(greenNodes);
            nodes.add(blueNodes);
            double maxArea = 0.0;
//            单种颜色节点计算
            for (int i = 0; i < 3; i++) {
                List<Node> cur = nodes.get(i);
                int size = cur.size();
                for (int j = 0; j < size - 2; j++) {
                    for (int k = j + 1; k < size - 1; k++) {
                        for (int l = k + 1; l < size; l++) {
                            maxArea = Math.max(maxArea, dis(cur.get(j), cur.get(k), cur.get(l)));
                        }
                    }
                }
            }

            if (flag) {
//                三种不同颜色节点计算
                for (int i = 0; i < nodes.get(0).size(); i++) {
                    Node first = nodes.get(0).get(i);
                    for (int j = 0; j < nodes.get(1).size(); j++) {
                        Node second = nodes.get(1).get(j);
                        for (int k = 0; k < nodes.get(2).size(); k++) {
                            Node third = nodes.get(2).get(k);

                            maxArea = Math.max(maxArea, dis(first, second, third));
                        }
                    }
                }
            }
            System.out.printf("%.5f\n", maxArea);
        }
    }

//    海伦公式计算三角形面积
    private static double dis(Node first, Node second, Node third) {
        double a = Math.sqrt(Math.pow(first.x - second.x, 2) +
                Math.pow(first.y - second.y, 2) + Math.pow(first.z - second.z, 2));

        double b = Math.sqrt(Math.pow(first.x - third.x, 2) +
                Math.pow(first.y - third.y, 2) + Math.pow(first.z - third.z, 2));

        double c = Math.sqrt(Math.pow(third.x - second.x, 2) +
                Math.pow(third.y - second.y, 2) + Math.pow(third.z - second.z, 2));

//        不能够成三角形
        if (a + b <= c || a + c <= b || b + c <= a) {
            return 0;
        }
        double half = (a + b + c) / 2;

        return Math.sqrt(Math.abs(half * (a - half) * (b - half) * (c - half)));

    }

    private static class Node {
        char color;
        int x, y, z;

        public Node(char color, int x, int y, int z) {
            this.color = color;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}


