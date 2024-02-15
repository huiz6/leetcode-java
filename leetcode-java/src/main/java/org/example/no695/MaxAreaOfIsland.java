package org.example.no695;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int maxArea = 0;
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (grid[h][w] == 1) {
                    maxArea = Integer.max(maxArea, this.dfs(grid, h, w));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int h, int w) {
        if (h < 0 || h >= grid.length || w < 0 || w >= grid[0].length || grid[h][w] == 0) {
            return 0;
        }
        grid[h][w] = 0;
        return 1 + this.dfs(grid, h - 1, w) + this.dfs(grid, h + 1, w) + this.dfs(grid, h, w - 1) +
                this.dfs(grid, h, w + 1);


    }

    public static void main(String[] args) {
        int[] gridRow1 = new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        int[] gridRow2 = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0};
        int[] gridRow3 = new int[]{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] gridRow4 = new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0};
        int[] gridRow5 = new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0};
        int[] gridRow6 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
        int[] gridRow7 = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0};
        int[] gridRow8 = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0};
        int[][] grid = new int[][]{gridRow1, gridRow2, gridRow3, gridRow4, gridRow5, gridRow6, gridRow7, gridRow8};
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));
    }

}
