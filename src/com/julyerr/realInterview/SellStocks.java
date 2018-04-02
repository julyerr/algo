package com.julyerr.realInterview;

/*
 * 解题思路可以参考leetcode一道sell Stocks的原题：https://blog.csdn.net/qq508618087/article/details/51678245
 *
 * */
public class SellStocks {
    public int calculateMax(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
//        初始化变量，分别表示第一次购买、出售，第二次购买、出售时的最大收益
        int firstBuy, secondBuy;
        firstBuy = secondBuy = Integer.MIN_VALUE;

        int firstSell, secondSell;
        firstSell = secondSell = 0;
        for (int i = 0; i < prices.length; i++) {
//            第一次购买，收益
            firstBuy = Math.max(firstBuy, -prices[i]);
//            第一次出售，收益
            firstSell = Math.max(firstSell, firstBuy + prices[i]);
//            第二次购买，收益
            secondBuy = Math.max(secondBuy, firstSell - prices[i]);
//            第二次出售，收益
            secondSell = Math.max(secondSell, secondBuy + prices[i]);
        }
        return secondSell;
    }
}
