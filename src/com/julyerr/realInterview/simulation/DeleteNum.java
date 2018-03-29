package com.julyerr.realInterview.simulation;

import java.util.Scanner;

public class DeleteNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n > 1000) {
                n = 1000;
            }
            Node[] nodes = new Node[n];
            nodes[0] = new Node(0,0);
            for (int i = 1; i < n; i++) {
                nodes[i] = new Node(i,i);
                nodes[i-1].next = nodes[i];
            }
            nodes[n-1].next = nodes[0];

            Node head = nodes[0];
            while(head.next!=head){
                Node tmp = head.next;
                tmp.next = tmp.next.next;
                head = tmp.next;
            }
            System.out.println(head.index);
        }
    }

    private static class Node{
        int val;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }

        int index;
        Node next;
    }
}
