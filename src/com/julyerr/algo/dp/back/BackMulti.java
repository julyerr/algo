package com.julyerr.algo.dp.back;

/*
 * 这篇blog讲解比较好：http://www.ahathinking.com/archives/109.html
 * 主要是利用二进制划分的方法，将给定数量的物品，分配成若干件物品
 * */

/*
输入：
4 20
    3     9     3
    5     9     1
    9     4     2
    8     1     3
输出：
36
* */

import java.util.Scanner;

public class BackMulti {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int sum = scanner.nextInt();
            int[] costs = new int[sum + 1];
            int[] prices = new int[sum + 1];

            int[] dp = new int[sum + 1];
            int index = 0;
            for (int i = 0; i < n; i++) {
                int cost = scanner.nextInt();
                int price = scanner.nextInt();
                int count = scanner.nextInt();
//                二进制分隔
                for (int j = 1; j <= count; j <<= 1) {
                    costs[index] = j * cost;
                    prices[index++] = j * price;
                    count -= j;
                }
                if (count > 0) {
                    costs[index] = count * cost;
                    prices[index++] = count * price;
                }
            }

//            01背包问题
            for (int i = 0; i < index; i++) {
                for (int j = sum; j >= costs[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - costs[i]] + prices[i]);
                }
            }
            System.out.println(dp[sum]);
        }
    }
}
