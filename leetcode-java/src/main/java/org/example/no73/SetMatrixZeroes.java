package org.example.no73;

import java.util.Arrays;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] rowZeroIndexes = new int[rows];
        int[] colZeroIndexes = new int[cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    rowZeroIndexes[r] = 1;
                    colZeroIndexes[c] = 1;
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (colZeroIndexes[c] == 1) {
                    matrix[r][c] = 0;
                }
            }
        }

        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                if (rowZeroIndexes[r] == 1) {
                    matrix[r][c] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        int[] row1 = new int[]{1, 1, 1};
        int[] row2 = new int[]{1, 0, 1};
        int[] row3 = new int[]{1, 1, 1};
        int[][] matrix = new int[][]{row1, row2, row3};
        setMatrixZeroes.setZeroes(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

}
