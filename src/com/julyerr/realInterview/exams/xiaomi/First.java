package com.julyerr.realInterview.exams.xiaomi;

import java.util.*;

/*
 * 没有思考清楚，16进制的abcdef
 * */

public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        List<Node> list = new ArrayList<>();
        Map<Long, Long> map = new HashMap<>();
        while (!(input = scanner.next()).equals("END")) {
            String[] strings = input.split("#");
            long val = 0;
            long base = Long.parseLong(strings[0]);
            for (int i = 0; i < strings[1].length(); i++) {
                val = val * base + strings[1].charAt(i) - '0';
            }
            list.add(new Node(input, val));
            if (!map.containsKey(val)) {
                map.put(val, 1l);
            } else {
                map.put(val, map.get(val) + 1);
            }
        }
        boolean flag = true;
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            if (map.get(node.val) == 1) {
                flag = false;
                System.out.println(node.string);
            }
        }
        if (flag) {
            System.out.println("None");
        }
    }

    private static class Node {
        public Node(String string, long val) {
            this.string = string;
            this.val = val;
        }

        String string;
        long val;
    }
}
