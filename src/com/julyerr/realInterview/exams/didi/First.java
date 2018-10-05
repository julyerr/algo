package com.julyerr.realInterview.exams.didi;

import java.util.*;

public class First {
    private static Set<Character> set1, set2;

    public static void main(String[] args) {
        set1 = new HashSet<>();
        set2 = new HashSet<>();
        char[] as = new char[]{'q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v'};
        char[] bs = new char[]{'y', 'u', 'i', 'o', 'p', 'h', 'j', 'k', 'l', 'b', 'n', 'm'};
        for (int i = 0; i < as.length; i++) {
            set1.add(as[i]);
        }
        for (int i = 0; i < bs.length; i++) {
            set2.add(bs[i]);
        }
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        List<String> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        int n = list.size();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(list.get(i), 0, i);
            price(nodes[i], a);
        }
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.val == o2.val) {
                    return o1.index - o2.index;
                }
                return o1.val - o2.val;
            }
        });
        if(n < 3){
            for (int i = 0; i < n-1; i++) {
                System.out.print(nodes[i].string+" ");
            }
            System.out.println(nodes[n-1].string);
            return;
        }
        for (int i = 0; i < 2; i++) {
            System.out.print(nodes[i].string+" ");
        }
        System.out.println(nodes[2].string);
    }

    private static class Node {
        public Node(String string, int val, int index) {
            this.string = string;
            this.val = Integer.MAX_VALUE;
            this.index = index;
        }

        String string;
        int val, index;
    }

    private static void price(Node node, String t) {
        String a = node.string;
        if (a.equals(t)) {
            node.val = 0;
            return;
        }
        int[][] dp = new int[a.length() + 1][t.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            dp[i][0] = 3 * i;
        }
        for (int i = 1; i <= t.length(); i++) {
            dp[0][i] = 3 * i;
        }
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                char m = a.charAt(i-1);
                char n = t.charAt(j-1);
                if (m == n) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (set1.contains(m) && set1.contains(n) ||
                            set2.contains(m) && set2.contains(n)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 2;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 3);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 3);
                }
            }
        }
        node.val = dp[a.length()][t.length()];
    }
}
