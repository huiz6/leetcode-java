package org.example.no714;

public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int days = prices.length;
        int[] buy = new int[days];
        buy[0] = -prices[0];
        int[] sell = new int[days];
        sell[0] = 0;
        for (int i = 1; i < days; i++) {
            buy[i] = Integer.max(sell[i - 1] - prices[i], buy[i - 1]);
            sell[i] = Integer.max(buy[i - 1] + prices[i] - fee, sell[i - 1]);
        }
        return sell[days - 1];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(new BestTimeToBuyAndSellStockWithTransactionFee().maxProfit(prices, fee));
    }

}
