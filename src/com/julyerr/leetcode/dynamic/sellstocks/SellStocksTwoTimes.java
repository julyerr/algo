package com.julyerr.leetcode.dynamic.sellstocks;

/*
 * 参考实现思路：https://blog.csdn.net/Dr_Unknown/article/details/51939121
 *
 * 针对i天划分为之前和之后的两笔收之和
 * */
public class SellStocksTwoTimes {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[] pre = new int[n];
        int[] post = new int[n];

        int curMin = prices[0];
        for (int i = 1; i < n; i++) {
            curMin = Math.min(curMin, prices[i]);
            pre[i] = Math.max(pre[i - 1], prices[i] - curMin);
        }

        int curMax = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            curMax = Math.max(curMax, prices[i]);
            post[i] = Math.max(post[i + 1], curMax - prices[i]);
        }

        int rt = Math.max(0, prices[1] - prices[0]);
        for (int i = 1; i < n - 1; i++) {
            rt = Math.max(rt, pre[i] + post[i]);
        }
        return rt;
    }
}
