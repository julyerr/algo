package com.julyerr.realInterview.exams.pingduoduo.shixi0403;

import java.util.*;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n =scanner.nextInt();
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                nodes[i] = new Node(x,y);
            }
            int count = n*(n-1)*(n-2)/6;
            Set<Double> set = new HashSet<>();
            for (int i = 0; i < n - 2; i++) {
                for (int j = i+1; j < n-1; j++) {
                    int tmp = 2;
                    if(nodes[i].x == nodes[j].x){
                        if(!set.contains(Double.MAX_VALUE)){
                            for (int k = j+1; k < n; k++) {
                                if(nodes[k].x == nodes[j].x){
                                    tmp++;
                                }
                            }
                            set.add(Double.MAX_VALUE);
                        }
                        if(tmp > 2){
                            count -= tmp*(tmp-1)*(tmp-2)/6;
                        }
                    }else{
                        double k = (nodes[j].y - nodes[i].y )/( nodes[j].x - nodes[j].x);
                        if(!set.contains(k)){
                            for (int l = j+1; l < n; l++) {
                                if(nodes[l].x == nodes[j].x){
                                    tmp++;
                                }
                            }
                            set.add(k);
                        }
                        if(tmp > 2){
                            count -= tmp*(tmp-1)*(tmp-2)/6;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static class Node{
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
