package org.example.no343;

public class IntegerBreak2 {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Integer.max(dp[i], Integer.max(j, dp[j]) * (i - j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new IntegerBreak2().integerBreak(45));
    }

}
