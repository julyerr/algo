package com.julyerr.algo.dp.back;

import java.util.Scanner;

/*
输入：
3 5
3 5
2 10
2 20
输出：
40
* */

/*
* 整个过程和01非常相似，01表示反序迭代，完全背包正序迭代
* */

public class BackNoLimit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //            输入处理
            int n = scanner.nextInt();
            int whole = scanner.nextInt();
            int[] cost = new int[n];
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                cost[i] = scanner.nextInt();
                prices[i] = scanner.nextInt();
            }

            int[] dp = new int[whole + 1];
            for (int i = 0; i < n; i++) {
                for (int j = cost[i]; j <= whole; j++) {
                    dp[j] = Math.max(dp[j], dp[j - cost[i]] + prices[i]);
                }
            }
            System.out.println(dp[whole]);
        }
    }
}
