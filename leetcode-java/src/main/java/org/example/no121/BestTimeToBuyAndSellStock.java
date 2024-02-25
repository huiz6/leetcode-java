package org.example.no121;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int lowestPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int price : prices) {
            lowestPrice = Integer.min(lowestPrice, price);
            maxProfit = Integer.max(price - lowestPrice, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,6,4,3,1};
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
    }

}
