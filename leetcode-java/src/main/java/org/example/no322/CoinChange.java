package org.example.no322;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int coinLength = coins.length;
        int[][] dp = new int[amount + 1][coinLength + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i][0] = amount + 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= coins.length; j++) {
                if (i >= coins[j - 1]) {
                    dp[i][j] = Integer.min(dp[i - coins[j - 1]][j] + 1, dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }

        }
        return dp[amount][coinLength] == amount + 1? -1 : dp[amount][coinLength];
    }


    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println(new CoinChange().coinChange(coins, amount));

//        int[] coins = new int[]{2};
//        int amount = 3;
//        System.out.println(new CoinChange().coinChange(coins, amount));

    }

}
