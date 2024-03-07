package org.example.no240;

public class SearchA2dMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = 0, column = n - 1;
        while (row < m && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] row1 = new int[]{1, 4, 7, 11, 15};
        int[] row2 = new int[]{2, 5, 8, 12, 19};
        int[] row3 = new int[]{3, 6, 9, 16, 22};
        int[] row4 = new int[]{10, 13, 14, 17, 24};
        int[] row5 = new int[]{18, 21, 23, 26, 30};
        int[][] matrix = new int[][]{row1, row2, row3, row4, row5};
        System.out.println(new SearchA2dMatrixII().searchMatrix(matrix, 31));
    }

}
