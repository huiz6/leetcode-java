package org.example.no123;

public class BestTimeToBuyAndSellStockIII2 {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int s1 = -prices[0], s2 = Integer.MIN_VALUE, s3 = Integer.MIN_VALUE, s4 = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            s1 = Integer.max(s1, -prices[i]);
            s2 = Integer.max(s2, prices[i] + s1);
            s3 = Integer.max(s3, s2 - prices[i]);
            s4 = Integer.max(s4, prices[i] + s3);
        }
        return s4;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(new BestTimeToBuyAndSellStockIII2().maxProfit(prices));
    }

}
