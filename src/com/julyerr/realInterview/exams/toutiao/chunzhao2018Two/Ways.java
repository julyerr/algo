package com.julyerr.realInterview.exams.toutiao.chunzhao2018Two;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ways {
    public static void main(String[] args) {
        Map<Character, Node> map = new HashMap<>();
        map.put('u', new Node(-1, 0));
        map.put('d', new Node(1, 0));
        map.put('l', new Node(0, -1));
        map.put('r', new Node(0, 1));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String direct = scanner.next();
            int n = scanner.nextInt();
            while (n-- > 0) {
                int N = scanner.nextInt();
                int M = scanner.nextInt();
                int X = scanner.nextInt();
                int Y = scanner.nextInt();
                int count = 0;
                for (int i = 0; i < direct.length(); i++) {
                    Node node = map.get(direct.charAt(i));
                    X += node.x;
                    Y += node.y;
                    count++;
                    if (X < 1 || X > N || Y < 1 || Y > M) {
                        break;
                    }
                }
                System.out.println(count);
            }
        }
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
/*
uuurrdddddl
3
5 6 3 3
5 6 4 2
6 6 4 2
* */