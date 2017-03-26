package com.leetcode.service.dp;

import com.leetcode.service.BiSolution;

/**
 * User: BichongLi
 * Date: 3/26/2017
 * Time: 10:23 AM
 */
public class CoinChange implements BiSolution<int[], Integer, Integer> {
    @Override
    public Integer solve(int[] coins, Integer amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != -1) {
                    if (dp[i] == 0) dp[i] = dp[i - coins[j]] + 1;
                    else {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            if (dp[i] == 0) dp[i] = -1;
        }
        return dp[amount];
    }
}
