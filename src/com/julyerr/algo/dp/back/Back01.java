package com.julyerr.algo.dp.back;

import java.util.Scanner;

/*
输入：
3 6
2 5
3 8
4 9
输出：
14
* */

/*
 * 状态转移方程:dp[j] = Math.max(dp[j],dp[j-cost[i]]+prices[i])
 * */
public class Back01 {
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

//            背包大小
            int[] dp = new int[whole + 1];
            for (int i = 0; i < n; i++) {
                for (int j = whole; j >= cost[i]; j--) {
//                    更新背包价值
                    dp[j] = Math.max(dp[j], dp[j - cost[i]] + prices[i]);
                }
            }
            System.out.println(dp[whole]);
        }
    }
}
