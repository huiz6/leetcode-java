package org.example.no97;

import java.util.Arrays;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Length = s1.length(), s2Length = s2.length(), s3Length = s3.length();
        if (s3Length != s2Length + s1Length) {
            return false;
        }
        boolean[][] dp = new boolean[s1Length + 1][s2Length + 1];
        for (int i = 0; i <= s1Length; i++) {
            Arrays.fill(dp[i], false);
        }

        for (int i = 0; i <= s1Length; i++) {
            if (s3.substring(0, i).equals(s1.substring(0, i))) {
                dp[i][0] = true;
            }
        }
        for (int i = 0; i <= s2Length; i++) {
            if (s3.substring(0, i).equals(s2.substring(0, i))) {
                dp[0][i] = true;
            }
        }

        for (int i = 1; i <= s1Length; i++) {
            for (int j = 1; j <= s2Length; j++) {
                if (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
                    dp[i][j] = true;
                } else if (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s1Length][s2Length];
    }

    public static void main(String[] args) {
        InterleavingString interleavingString = new InterleavingString();
        System.out.println(interleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(interleavingString.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(interleavingString.isInterleave("", "", ""));
    }

}
