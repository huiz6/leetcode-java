package org.example.no650;

public class TwoKeysKeyboard {

    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for(int j = i / 2; j >= 2; j--) {
                if (i % j == 0) {
                    isPrime = false;
                    dp[i] = dp[j] + i / j;
                    break;
                }
            }
            if (isPrime) {
                dp[i] = i;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new TwoKeysKeyboard().minSteps(8));
    }

}
