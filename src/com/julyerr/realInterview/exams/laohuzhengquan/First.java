package com.julyerr.realInterview.exams.laohuzhengquan;

import java.util.Scanner;

public class First {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int val = 10000;
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int times = maxProfit(nums);
        System.out.println(val * (1 + times));
    }
}
