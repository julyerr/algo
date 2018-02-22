package com.julyerr.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NSumM {
    static List<List<Integer>> rt;
    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            rt = new ArrayList<>();
            dfs(0, new ArrayList<>(), 0);
            for (int i = 0; i < rt.size(); i++) {
                List<Integer> tmp = rt.get(i);
                for (int j = 0; j < tmp.size()-1; j++) {
                    System.out.print(tmp.get(j)+" ");
                }
                System.out.println(tmp.get(tmp.size()-1));
            }
        }
    }

    private static void dfs(int start, List<Integer> cur, int sum) {
        if (sum == m) {
            rt.add(new ArrayList<>(cur));
            return;
        } else if (sum > m) {
            return;
        }
        for (int i = start; i < n; i++) {
            cur.add(i+1);
            dfs(i+1, cur, sum + i+1);
            cur.remove(cur.size() - 1);
        }
    }
}
