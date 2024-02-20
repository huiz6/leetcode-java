package org.example.no279;

public class PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (i - j * j >= 0) {
                    min = Integer.min(min, dp[i - j * j]);
                } else {
                    break;
                }
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(1));
    }

}
