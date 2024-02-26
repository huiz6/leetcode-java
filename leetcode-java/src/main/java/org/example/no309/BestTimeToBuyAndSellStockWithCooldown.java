package org.example.no309;

public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        int days = prices.length;
        if (days <= 1) {
            return 0;
        }

        int[] buy = new int[days], sell = new int[days], cooldown = new int[days];
        buy[0] = -prices[0];
        for (int i = 1; i < days; i++) {
            buy[i] = Integer.max(cooldown[i - 1] -prices[i], buy[i - 1]);
            sell[i] = Integer.max(sell[i - 1], prices[i] + buy[i]);
            cooldown[i] = Integer.max(sell[i - 1], cooldown[i - 1]);
        }
        return Integer.max(cooldown[days - 1], sell[days - 1]);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        System.out.println(new BestTimeToBuyAndSellStockWithCooldown().maxProfit(prices));
    }

}
