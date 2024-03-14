package org.example.no566;

import java.util.Arrays;

public class ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int originalRow = mat.length;
        int originalCol = mat[0].length;
        if (originalRow * originalCol != r * c) {
            return mat;
        }
        int[][] reshapeMatrix = new int[r][c];
        int index = 0;
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                reshapeMatrix[row][col] = mat[index / originalCol][index % originalCol];
                index++;
            }
        }
        return reshapeMatrix;
    }

    public static void main(String[] args) {
        int[] row1 = new int[]{1, 2, 3, 4};
        int[] row2 = new int[]{3, 4};
        int[][] mat = new int[][]{row1};
        int r = 2, c = 2;
        int[][] reshapeMatrix = new ReshapeTheMatrix().matrixReshape(mat, r, c);
        for (int[] row : reshapeMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

}
