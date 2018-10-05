package com.julyerr.realInterview.exams.aiyiqi.qiu2018;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N =scanner.nextInt();
        int M =scanner.nextInt();
        int P =scanner.nextInt();
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(scanner.nextInt());
        }
        Node ref = nodes[P-1];
        for (int i = 0; i < M; i++) {
            String input = scanner.next();
            int val = scanner.nextInt();
            if(input.equals("A")){
                nodes[val-1].val++;
            }else{
                nodes[val-1].val--;
            }
        }
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.val - o1.val;
            }
        });
        int rt = 0;
        for (int i = 0; i < N; i++) {
            if(nodes[i] == ref){
                rt = i+1;
                break;
            }
        }
        System.out.println(rt);
    }
    private static class Node{
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

}
