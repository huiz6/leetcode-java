package org.example.no64;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Integer.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[row - 1][column - 1];
    }

    public static void main(String[] args) {
        int[] row1 = new int[]{1, 3, 1};
        int[] row2 = new int[]{1, 5, 1};
        int[] row3 = new int[]{4, 2, 1};
        int[][] grid = new int[][]{row1, row2, row3};
        System.out.println(new MinimumPathSum().minPathSum(grid));
    }

}
