package org.example.no934;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ShortestBridge {

    public int shortestBridge(int[][] grid) {
        int row = grid.length, column = grid[0].length;
        Deque<List<Integer>> points = new ArrayDeque<>();
        boolean flipped = false;
        for (int r = 0; r < row; r++) {
            if (flipped) {
                break;
            }
            for (int c = 0; c < column; c++) {
                if (grid[r][c] == 1) {
                    this.dfs(grid, points, row, column, r, c);
                    flipped = true;
                    break;
                }
            }
        }

        int x, y;
        int level = 0;
        while (!points.isEmpty()) {
            ++level;
            int nPoints = points.size();
            while (nPoints-- > 0) {
                List<Integer> point = points.pop();
                int r = point.get(0);
                int c = point.get(1);
                int[][] nextPoints = new int[4][2];
                nextPoints[0] = new int[]{r + 1, c};
                nextPoints[1] = new int[]{r - 1, c};
                nextPoints[2] = new int[]{r, c + 1};
                nextPoints[3] = new int[]{r, c - 1};
                for (int[] nextPoint : nextPoints) {
                    x = nextPoint[0];
                    y = nextPoint[1];
                    if (x >= 0 && y >= 0 && x < row && y < column) {
                        if (grid[x][y] == 2) {
                            continue;
                        }
                        if (grid[x][y] == 1) {
                            return level;
                        }
                        int finalX = x;
                        int finalY = y;
                        points.addLast(
                                new ArrayList<Integer>() {{
                                    add(finalX);
                                    add(finalY);
                                }}
                        );
                        grid[x][y] = 2;
                    }
                }
            }
        }

        return 0;
    }

    private void dfs(int[][] grid, Deque<List<Integer>> points, int row, int column, int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= column || grid[r][c] == 2) {
            return;
        }

        if (grid[r][c] == 0) {
            points.addLast(
                    new ArrayList<Integer>() {{
                        add(r);
                        add(c);
                    }}
            );
            return;
        }
        grid[r][c] = 2;
        this.dfs(grid, points, row, column, r + 1, c);
        this.dfs(grid, points, row, column, r - 1, c);
        this.dfs(grid, points, row, column, r, c + 1);
        this.dfs(grid, points, row, column, r, c - 1);
    }

    public static void main(String[] args) {
        int[] row1 = new int[]{1, 1, 1, 1, 1};
        int[] row2 = new int[]{1, 0, 0, 0, 1};
        int[] row3 = new int[]{1, 0, 1, 0, 1};
        int[] row4 = new int[]{1, 0, 0, 0, 1};
        int[] row5 = new int[]{1, 1, 1, 1, 1};
        int[][] grid = new int[][]{row1, row2, row3, row4, row5};
        System.out.println(new ShortestBridge().shortestBridge(grid));
    }

}
