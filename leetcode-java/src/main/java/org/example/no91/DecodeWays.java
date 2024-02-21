package org.example.no91;

public class DecodeWays {

    public int numDecodings(String s) {
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[length] = 1;
        if (s.charAt(length - 1) == '0') {
            dp[length - 1] = 0;
        } else {
            dp[length - 1] = 1;
        }

        for (int i = length - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) {
                ans2 = dp[i + 2];
            }
            dp[i] = dp[i + 1] + ans2;
        }
        return dp[0];
     }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("27"));
    }

}
