package org.example.no221;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length, column = matrix[0].length, maxEdge = 0;
        int[][] dp = new int[row + 1][column + 1];
        for (int r = 1; r <= row; r++) {
            for (int c = 1; c <= column; c++) {
                if (matrix[r - 1][c - 1] == '1') {
                    dp[r][c] = Integer.min(dp[r - 1][c - 1], Integer.min(dp[r - 1][c], dp[r][c - 1])) + 1;
                }
                maxEdge = Integer.max(dp[r][c], maxEdge);
            }
        }
        return (int) Math.pow(maxEdge, 2);
    }

    public static void main(String[] args) {
        char[] row1 = new char[]{'1', '0', '1', '0', '0'};
        char[] row2 = new char[]{'1', '0', '1', '1', '1'};
        char[] row3 = new char[]{'1', '1', '1', '1', '1'};
        char[] row4 = new char[]{'1', '0', '0', '1', '0'};
        char[][] matrix = new char[][]{row1, row2, row3, row4};
        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }

}
