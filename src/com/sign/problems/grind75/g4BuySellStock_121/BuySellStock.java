package com.sign.problems.grind75.g4BuySellStock_121;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class BuySellStock {
    public int maxProfit(int[] prices) {
        int max = 0;
        if (prices.length < 2) {
            return max;
        }

        int buy = 0;
        int sell = 1;
        while (sell < prices.length) {
            int profit = prices[sell] - prices[buy];
            if (profit > 0) {
                max = Math.max(max, profit);
                sell++;
            } else {
                // loss
                buy = sell;
                sell = buy + 1;
            }
        }
        return max;
    }

}
