package org.example.no474;

public class OnesAndZeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int k = 1; k <= strs.length; k++) {
            int zeroNum = 0, oneNum = 0;
            for (char c : strs[k - 1].toCharArray()) {
                if (c == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i < zeroNum || j < oneNum) {
                        dp[k][i][j] = dp[k - 1][i][j];
                    } else {
                        dp[k][i][j] = Integer.max(dp[k - 1][i][j], dp[k - 1][i - zeroNum][j - oneNum] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        System.out.println(new OnesAndZeroes().findMaxForm(strs, m, n));
    }

}
