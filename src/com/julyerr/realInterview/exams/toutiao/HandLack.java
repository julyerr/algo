package com.julyerr.niuke.company.toutiao;

import java.util.*;

public class HandLack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int c = scanner.nextInt();
            List<LinkedList<Integer>> colors = new ArrayList<>(c+1);
            List<LinkedList<Integer>> colors2 = new ArrayList<>(c+1);
            for (int i = 0; i < c+1; i++) {
                colors.add(new LinkedList<>());
                colors2.add(new LinkedList<>());
            }
            int index = 1;
            for (int i = 0; i < n; i++) {
                int count = scanner.nextInt();
                for (int j = 0; j < count; j++) {
                    int tmp = scanner.nextInt();
                    colors.get(tmp).add(i+1);
                    if(index<m){
                        colors2.get(tmp).add(n+i+1);
                    }
                }
                index++;
            }
            for (int i = 1; i < c+1; i++) {
                List<Integer> list = colors2.get(i);
                if(list.size()!=0){
                    for (int j = 0; j < list.size(); j++) {
                        colors.get(i).add(list.get(j));
                    }
                }
            }
            int count =0;
            for (int i = 0; i < c; i++) {
                List<Integer> list = colors.get(i+1);
                for (int j = 0; j < list.size() - 1; j++) {
                    if(list.get(j+1)-list.get(j)<m){
                        count++;
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
