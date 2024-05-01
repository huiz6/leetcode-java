package org.example.no54;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralOrderList = new ArrayList<>();
        int col = matrix[0].length, row = matrix.length, c = 0, r = 0, step = 0, direction = 0;
        boolean[][] path = new boolean[row][col];
        int[] dir1 = new int[]{0, 1};
        int[] dir2 = new int[]{1, 0};
        int[] dir3 = new int[]{0, -1};
        int[] dir4 = new int[]{-1, 0};
        int[][] dirArray = new int[][]{dir1, dir2, dir3, dir4};
        while (step < row * col) {
            spiralOrderList.add(matrix[r][c]);
            path[r][c] = true;
            step++;
            if (r + dirArray[direction % 4][0] >= row || r + dirArray[direction % 4][0] < 0 ||
                    c + dirArray[direction % 4][1] >= col || c + dirArray[direction % 4][1] < 0 ||
                    path[r + dirArray[direction % 4][0]][c + dirArray[direction % 4][1]]
            ) {
                direction++;
            }
            r += dirArray[direction % 4][0];
            c += dirArray[direction % 4][1];
        }
        return spiralOrderList;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[] row1 = new int[]{1, 2, 3};
        int[] row2 = new int[]{4, 5, 6};
        int[] row3 = new int[]{7, 8, 9};
        int[][] matrix = new int[][]{row1, row2, row3};
        System.out.println(spiralMatrix.spiralOrder(matrix));
    }

}
