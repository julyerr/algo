package com.julyerr.realInterview.exams.zhaoyinkeji;

//        本文来自 Dr_Unknown 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/Dr_Unknown/article/details/51939121?utm_source=copy

import java.util.Scanner;

public class First {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int n = prices.length;
        int[] preProfit = new int[n];
        int[] postProfit = new int[n];

        int curMin = prices[0];
        //第i时候卖出
        for (int i = 1; i < n; i++) {
            curMin = Math.min(curMin, prices[i]);
            preProfit[i] = Math.max(preProfit[i - 1], prices[i] - curMin);
        }

        int curMax = prices[n - 1];
        //第i时候买入
        for (int i = n - 2; i >= 0; i--) {
            curMax = Math.max(curMax, prices[i]);
            postProfit[i] = Math.max(postProfit[i + 1], curMax - prices[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, preProfit[i] + postProfit[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strings = input.split(" ");
        int[] prices = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            prices[i] = Integer.parseInt(strings[i]);
        }
        System.out.println(new First().maxProfit(prices));
    }
}
