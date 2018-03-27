package com.julyerr.niuke.company.meituan;

import java.util.Scanner;

/*
 * 掷筛子到达N有多少种方式
 * */
public class StepN {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            count = 0;
            dfs(1, n);
            System.out.println(count);
        }
    }

    //    类似leetcode上的combination.使用递归的方式
    private static void dfs(int start, int target) {
        if (target == 0) {
            count++;
            return;
        }
        for (int i = 1; i <= 6; i++) {
            if (target < i) {
                return;
            }
            dfs(i, target - i);
        }
    }
}
