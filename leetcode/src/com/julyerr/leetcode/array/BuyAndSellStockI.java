package com.julyerr.leetcode.array;

/**
 * Best Time to Buy and Sell Stock

 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.
 */

/**
 * compare the profit for each price
 */
public class BuyAndSellStockI {
    public int maxProfit(int[] prices){
        //check if the prices is valid
        if(prices == null || prices.length<=1){
            return 0;
        }

        int maxProfit= 0, lowest = Integer.MAX_VALUE;
        for (int v :
                prices) {
            //update the lowest if necessary
            lowest = Math.min(lowest,v);
            maxProfit = Math.max(maxProfit,v-lowest);
        }
        return maxProfit;
    }
}

