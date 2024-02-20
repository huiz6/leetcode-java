package org.example.no542;

import java.util.Arrays;

public class ZeroOneMatrix {

    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        int[][] minDistance = new int[row][column];
        for (int i = 0; i < row; i++) {
            Arrays.fill(minDistance[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (mat[i][j] == 0) {
                    minDistance[i][j] = 0;
                } else {
                    if (j > 0) {
                        minDistance[i][j] = Integer.min(minDistance[i][j], minDistance[i][j - 1] + 1);
                    }
                    if (i > 0) {
                        minDistance[i][j] = Integer.min(minDistance[i][j], minDistance[i - 1][j] + 1);
                    }
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = column - 1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    if (j < column - 1) {
                        minDistance[i][j] = Integer.min(minDistance[i][j], minDistance[i][j + 1] + 1);
                    }
                    if (i < row - 1) {
                        minDistance[i][j] = Integer.min(minDistance[i][j], minDistance[i + 1][j] + 1);
                    }
                }
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        int[] row1 = new int[]{0, 0, 0};
        int[] row2 = new int[]{0, 1, 0};
        int[] row3 = new int[]{1, 1, 1};
        int[][] mat = new int[][]{row1, row2, row3};
        int[][] minDistance = new ZeroOneMatrix().updateMatrix(mat);
        for (int[] row : minDistance) {
            System.out.println(Arrays.toString(row));
        }
    }

}
