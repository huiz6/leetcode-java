package org.example.no417;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int height = heights.length;
        int width = heights[0].length;
        int[][] pacificReach = new int[height][width];
        int[][] atlanticReach = new int[height][width];
        for (int i = 0; i < width; i++) {
            this.dfs(heights, pacificReach, 0, i);
            this.dfs(heights, atlanticReach, height - 1, i);
        }
        for (int i = 0; i < height; i++) {
            this.dfs(heights, pacificReach, i, 0);
            this.dfs(heights, atlanticReach, i, width - 1);
        }
        List<List<Integer>> resultList = new ArrayList<>();
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (pacificReach[h][w] == 1 && atlanticReach[h][w] == 1) {
                    int finalH = h;
                    int finalW = w;
                    resultList.add(new ArrayList<Integer>() {{
                        add(finalH);
                        add(finalW);
                    }});
                }
            }
        }
        return resultList;
    }

    private void dfs(int[][] heights, int[][] reachArea, int h, int w) {
        if (reachArea[h][w] == 1) {
            return;
        }
        reachArea[h][w] = 1;
        if (h + 1 < heights.length && heights[h + 1][w] >= heights[h][w]) {
            this.dfs(heights, reachArea, h + 1, w);
        }
        if (h - 1 >= 0 && heights[h - 1][w] >= heights[h][w]) {
            this.dfs(heights, reachArea, h - 1, w);
        }
        if (w + 1 < heights[0].length && heights[h][w + 1] >= heights[h][w]) {
            this.dfs(heights, reachArea, h, w + 1);
        }
        if (w - 1 >= 0 && heights[h][w - 1] >= heights[h][w]) {
            this.dfs(heights, reachArea, h, w - 1);
        }

    }

    public static void main(String[] args) {
        int[] row1 = new int[]{1, 2, 2, 3, 5};
        int[] row2 = new int[]{3, 2, 3, 4, 4};
        int[] row3 = new int[]{2, 4, 5, 3, 1};
        int[] row4 = new int[]{6, 7, 1, 4, 5};
        int[] row5 = new int[]{5, 1, 1, 2, 4};
        int[][] heights = new int[][]{row1, row2, row3, row4, row5};
        List<List<Integer>> waterFlowList = new PacificAtlanticWaterFlow().pacificAtlantic(heights);
        for (List<Integer> coordinate : waterFlowList) {
            System.out.printf("x: %d, y: %d%n", coordinate.get(0), coordinate.get(1));
        }
    }

}
