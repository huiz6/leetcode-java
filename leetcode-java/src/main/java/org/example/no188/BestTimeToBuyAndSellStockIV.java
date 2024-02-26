package org.example.no188;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][k + 1];
        Arrays.fill(dp[0], 0);
        for (int t = 1; t <= k; t++) {
            for (int i = 1; i < prices.length; i++) {
                int min = prices[0];
                for (int j = 1; j <= i - 1; j++) {
                    min = Integer.min(min, prices[j] - dp[j - 1][t - 1]);
                }
                dp[i][t] = Integer.max(dp[i - 1][t], prices[i] - min);
            }
        }
        return dp[prices.length - 1][k];
    }

    public static void main(String[] args) {

    }

}
