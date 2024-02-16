package org.example.no51;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resList = new ArrayList<>();
        int[][] chessboard = new int[n][n];
        boolean[] columnStatus = new boolean[n];
        boolean[] lDiagStatus = new boolean[2 * n - 1];
        boolean[] rDiagStatus = new boolean[2 * n - 1];
        this.backTracking(chessboard, columnStatus, lDiagStatus, rDiagStatus, 0, n, resList);
        return resList;
    }

    private void backTracking(
            int[][] chessboard, boolean[] columnStatus, boolean[] lDiagStatus, boolean[] rDiagStatus, int row,
            int n, List<List<String>> resList
    ) {
        if (row == n) {
            resList.add(this.processChessboard(chessboard));
            return;
        }

        for (int column = 0; column < n; column++) {
            if (columnStatus[column] || lDiagStatus[n - 1 + column - row] || rDiagStatus[column + row]) {
                continue;
            }
            chessboard[row][column] = 1;
            columnStatus[column] = true;
            lDiagStatus[n - 1 + column - row] = true;
            rDiagStatus[column + row] = true;
            this.backTracking(chessboard, columnStatus, lDiagStatus, rDiagStatus, row + 1, n, resList);
            chessboard[row][column] = 0;
            columnStatus[column] = false;
            lDiagStatus[n - 1 + column - row] = false;
            rDiagStatus[column + row] = false;
        }
    }

    private List<String> processChessboard(int[][] chessboard) {
        List<String> strList = new ArrayList<>();
        int length = chessboard.length;
        for (int[] row : chessboard) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append(row[i] == 1 ? "Q" : ".");
            }
            strList.add(sb.toString());
        }
        return strList;
    }

    public static void main(String[] args) {
        List<List<String>> resList = new NQueens().solveNQueens(6);
        for (List<String> res : resList) {
            for (String row : res) {
                System.out.println(row);
            }
            System.out.println("****************");
        }
    }
}
