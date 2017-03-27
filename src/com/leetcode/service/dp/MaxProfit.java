package com.leetcode.service.dp;

import com.leetcode.service.Solution;

/**
 * User: BichongLi
 * Date: 3/27/2017
 * Time: 10:02 AM
 */
public class MaxProfit implements Solution<int[], Integer> {
    @Override
    public Integer solve(int[] prices) {
        if (prices.length < 2) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        sell[0] = 0;
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[1], -prices[0]);
        sell[1] = Math.max(buy[0] + prices[1], sell[0]);
        for (int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(sell[i - 2] - prices[i], buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
        }
        return sell[prices.length - 1];
    }
}
