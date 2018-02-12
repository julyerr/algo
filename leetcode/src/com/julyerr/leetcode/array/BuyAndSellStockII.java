package com.julyerr.leetcode.array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit.
 You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

/**
 * if gains the profit , just sell it out
 */
public class BuyAndSellStockII {
    public int maxProfit(int[] prices){
        //check if the prices is valid
        if(prices == null || prices.length<=1){
            return 0;
        }
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if(prices[i-1]<prices[i]){
                profit+= prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}


