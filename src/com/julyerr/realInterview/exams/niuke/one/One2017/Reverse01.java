package com.julyerr.realInterview.exams.niuke.one.One2017;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 参考大神：https://www.nowcoder.com/questionTerminal/9c4c9d10e3db4448b906c6e6cea22b7f @OceanFan
 * 有部分人使用数学推断得到结果但是比较难想，使用bfs还好理解一点
 * 有起始状态和结束状态，计算其中的变化信息考虑使用bfs
 * */
public class Reverse01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(reverse01(a, b, k));
        }
    }

    private static int reverse01(int a, int b, int k) {
//        已经完成
        if (a == 0 && b == 0) {
            return 0;
        }
//        不可能反转成功
        if (a + b < k) {
            return -1;
        }

        boolean[] visited = new boolean[a + b + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, b, 0));
        visited[a] = true;
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            if (tmp.a == 0) {
                return tmp.times;
            }
//            对于1~min(tmp.a,k)个0进行反转
            for (int i = 1; i <= Math.min(tmp.a, k); i++) {
//                1不够反转,继续操作
                if (k - i > tmp.b) {
                    continue;
                }
                int newa = tmp.a - i + (k - i);
                if (newa == 0) {
                    return tmp.times + 1;
                }
                if (!visited[newa]) {
                    visited[newa] = true;
                    queue.add(new Node(newa, tmp.a + tmp.b - newa, tmp.times + 1));
                }
            }
        }
        return -1;
    }

    private static class Node {
        int a, b, times;

        public Node(int a, int b, int times) {
            this.a = a;
            this.b = b;
            this.times = times;
        }
    }
}
