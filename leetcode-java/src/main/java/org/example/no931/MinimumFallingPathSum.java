package org.example.no931;

import java.util.Arrays;

public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        System.arraycopy(matrix[0], 0, dp[0], 0, n);
        for (int r = 1; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (c == 0) {
                    dp[r][c] = Math.min(dp[r - 1][c], dp[r - 1][c + 1]) + matrix[r][c];
                } else if (c == n - 1) {
                    dp[r][c] = Math.min(dp[r - 1][c], dp[r - 1][c - 1]) + matrix[r][c];
                } else {
                    dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r - 1][c - 1]), dp[r - 1][c + 1]) + matrix[r][c];
                }
            }
        }
        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }

    public static void main(String[] args) {
        MinimumFallingPathSum minimumFallingPathSum = new MinimumFallingPathSum();
        int[] row1 = new int[]{2, 1, 3};
        int[] row2 = new int[]{6, 5, 4};
        int[] row3 = new int[]{7, 8, 9};
        int[][] matrix = new int[][]{row1, row2, row3};
        System.out.println(minimumFallingPathSum.minFallingPathSum(matrix));
    }

}
