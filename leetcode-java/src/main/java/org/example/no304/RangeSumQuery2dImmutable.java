package org.example.no304;

public class RangeSumQuery2dImmutable {

    private final int[][] sum;

    public RangeSumQuery2dImmutable(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        this.sum = new int[rows + 1][columns + 1];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                sum[row + 1][column + 1] = sum[row][column + 1] + sum[row + 1][column] - sum[row][column] + matrix[row][column];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return this.sum[row2 + 1][col2 + 1] - this.sum[row2 + 1][col1] - this.sum[row1][col2 + 1] + this.sum[row1][col1];
    }

    public static void main(String[] args) {
        int[] row1 = new int[]{3, 0, 1, 4, 2};
        int[] row2 = new int[]{5, 6, 3, 2, 1};
        int[] row3 = new int[]{1, 2, 0, 1, 5};
        int[] row4 = new int[]{4, 1, 0, 1, 7};
        int[] row5 = new int[]{1, 0, 3, 0, 5};
        int[][] matrix = new int[][]{row1, row2, row3, row4, row5};
        RangeSumQuery2dImmutable rangeSumQuery2dImmutable = new RangeSumQuery2dImmutable(matrix);
        System.out.println(rangeSumQuery2dImmutable.sumRegion(2, 1, 4, 3));
    }

}
