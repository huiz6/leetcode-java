package org.example.no63;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;
        for (int r = 1; r < rows; r++) {
            dp[r][0] = obstacleGrid[r][0] == 1 ? 0 : dp[r - 1][0];
        }
        for (int c = 1; c < cols; c++) {
            dp[0][c] = obstacleGrid[0][c] == 1 ? 0 : dp[0][c - 1];
        }
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                dp[r][c] = obstacleGrid[r][c] == 1 ? 0 : dp[r][c - 1] + dp[r - 1][c];
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        UniquePathsII uniquePathsII = new UniquePathsII();
        int[] row11 = new int[]{0, 0, 0};
        int[] row12 = new int[]{0, 1, 0};
        int[] row13 = new int[]{0, 0, 0};
        int[][] obstacleGrid1 = new int[][]{row11, row12, row13};
        System.out.println(uniquePathsII.uniquePathsWithObstacles(obstacleGrid1));

        int[] row21 = new int[]{0, 1};
        int[] row22 = new int[]{0, 0};
        int[][] obstacleGrid2 = new int[][]{row21, row22};
        System.out.println(uniquePathsII.uniquePathsWithObstacles(obstacleGrid2));
    }

}
