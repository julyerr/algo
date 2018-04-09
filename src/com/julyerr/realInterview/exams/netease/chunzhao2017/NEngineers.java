package com.julyerr.realInterview.exams.netease.chunzhao2017;

import java.util.Scanner;

/*
 * 6 012345 012345 012345 012345 012345 012345
 * 720
 * */
public class NEngineers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = scanner.next();
            }
//            有六项任务
            boolean[] used = new boolean[6];
            dfs(used, strs, 0);
            System.out.println(count);
        }
    }

    private static int count = 0;
    private static int n = 0;

    private static void dfs(boolean[] visited, String[] strings, int cur) {
        if (cur == n) {
            count++;
            return;
        }
        String curS = strings[cur];
        for (int i = 0; i < curS.length(); i++) {
            int tmp = curS.charAt(i) - '0';
            if (!visited[tmp]) {
                visited[tmp] = true;
                dfs(visited, strings, cur + 1);
                visited[tmp] = false;
            }
        }
    }
}
