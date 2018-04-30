package com.julyerr.leetcode.dynamic.sellstocks;

import java.util.Arrays;

/*
* 参考大神的解题思路:https://blog.csdn.net/qq508618087/article/details/51678245
*
* 针对k进行讨论：
* 如果K>=len/2，可以任意次交易，只需要有收入就卖出;
* 如果k<len/2，设置buy和sell两个数组，分别表示第i次，buy[i]和sell[i]时对应的最大收入
    buy[i] = Math.max(buy[i],sell[i-1]-curPrice);
    sell[i] = Math.max(sell[i],buy[i]+curPrice);
* */
public class SellStocksIII {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k < 1) {
            return 0;
        }
        int len = prices.length;
//        如果交易的次数大于或者等于总数的一半
        if (k >= len / 2) {
            int maxProfit = 0;
            for (int i = 1; i < len; i++) {
                if (prices[i] - prices[i - 1] > 0) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
//        设置buy,sell两个数组保存状态
        int[] buy = new int[k + 1];
//        初始化的时候，设置最小收益
        Arrays.fill(buy, Integer.MIN_VALUE);
        int[] sell = new int[k + 1];

        for (int i = 0; i < len; i++) {
//
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k];
    }
}
