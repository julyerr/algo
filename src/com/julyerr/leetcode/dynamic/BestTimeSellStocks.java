package com.julyerr.leetcode.dynamic;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one0327
 * transaction (ie, buy one0327 and sell one0327 share of the stock), design an algorithm to find the maximum profit.
 */

//获取的得到的最大的利益，随着每天的变化进行动态的调整
public class BestTimeSellStocks {
    public int maxProfit(int[] array) {
        int minest = array[0];
        int maxProfit = 0;
        for (int i = 0; i < array.length; i++) {
            if (minest < array[i]) {
                minest = array[i];
            }
            maxProfit = Math.max(maxProfit, array[i] - minest);
        }
        return maxProfit;
    }
}
