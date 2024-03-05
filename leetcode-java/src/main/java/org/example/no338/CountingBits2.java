package org.example.no338;

import java.util.Arrays;

public class CountingBits2 {

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i >> 1];
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        CountingBits2 countingBits = new CountingBits2();
        int[] resultArray = countingBits.countBits(4);
        System.out.println(Arrays.toString(resultArray));
    }

}
