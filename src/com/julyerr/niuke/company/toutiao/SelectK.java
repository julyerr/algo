package com.julyerr.niuke.company.toutiao;

import java.util.*;

public class SelectK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            Map<Integer, List<Integer>> people = new HashMap<>();
            for (int i = 0; i < count; i++) {
                int k = scanner.nextInt();
                if (people.get(k)==null) {
                    people.put(k,new ArrayList<>());
                }
                people.get(k).add(i+1);
            }
            int times = scanner.nextInt();
            while (times-- > 0) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                int k = scanner.nextInt();
                int sum = 0;
                List<Integer> list = people.get(k);
                if (list != null && list.size() != 0 && start <= list.get(list.size() - 1) && end >= list.get(0)) {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i) >= start && list.get(i) <= end) {
                            sum++;
                        }
                    }
                }
                System.out.println(sum);
            }
        }
    }
}
