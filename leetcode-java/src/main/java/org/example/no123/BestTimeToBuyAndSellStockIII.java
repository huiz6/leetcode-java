package org.example.no123;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        int TRANSACTION_COUNT = 2;
        int[][] dp = new int[prices.length][TRANSACTION_COUNT + 1];
        Arrays.fill(dp[0], 0);
        for (int k = 1; k <= TRANSACTION_COUNT; k++) {
            for (int i = 1; i < prices.length; i++) {
                int min = prices[0];
                for (int j = 1; j <= i - 1; j++) {
                    min = Integer.min(min, prices[j] - dp[j - 1][k - 1]);
                }
                dp[i][k] = Integer.max(dp[i - 1][k], prices[i] - min);
            }
        }
        return dp[prices.length - 1][TRANSACTION_COUNT];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(prices));
    }

}
