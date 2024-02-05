package org.example.no122;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int i = 0;
        int j;
        int maxProfit = 0;
        while (true) {
            j = i + 1;
            while (j < prices.length) {
                if (prices[j] >= prices[j - 1]) {
                    j++;
                } else {
                    maxProfit += prices[j - 1] - prices[i];
                    i = j;
                    break;
                }
            }
            if (j >= prices.length) {
                maxProfit += prices[j - 1] - prices[i];
                break;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(prices));
    }

}
