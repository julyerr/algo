package com.julyerr.leetcode.dynamic.sellstocks;

import java.util.Arrays;

/*
 * 状态转移方程
 * buy[i] = max(buy[i-1],sell[i-2]-price[i]);
 * sell[i] = max(sell[i-1],buy[i-1]+sell[i]);
 * */
public class BuyStocksWithCoolDown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        buy[1] = Math.max(buy[0], -prices[1]);
        sell[1] = Math.max(0, buy[0] + prices[1]);

        for (int i = 2; i < prices.length; i++) {
//            这次买入，还是上次买入
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
//            这次卖出，还是上次卖出
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }
}
