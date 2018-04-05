package com.julyerr.realInterview.exams.tencent.ChunZhao2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicChoose {
    private static final int NOR=1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int K = scanner.nextInt();
            int A = scanner.nextInt();
            int X = scanner.nextInt();
            int B = scanner.nextInt();
            int Y = scanner.nextInt();
            List<Node> rt = new ArrayList<>();
            int tmpX = K / A;
            int xBound = tmpX > X ? X : tmpX;
            for (int i = xBound; i >= 0; i--) {
                int tmp = K - i * A;
                if (tmp % B == 0) {
                    rt.add(new Node(i, tmp / B));
                }
            }
            long sum = 0;
            for (Node node :
                    rt) {
                sum = (sum + (CNM(X, node.m)%NOR) * (CNM(Y, node.n)%NOR))%NOR;;
            }
            System.out.println(sum);
        }
    }

    private static long CNM(int n, int m) {
        long tmpA = 1;
        long tmpB = 1;
        int tmp = m;
        for (int i = 0; i < tmp; i++) {
            tmpA *= n;
            tmpB *= m;
            n--;
            m--;
        }
        return tmpA / tmpB;
    }

    private static class Node {
        int m, n;

        public Node(int m, int n) {
            this.m = m;
            this.n = n;
        }
    }
}
