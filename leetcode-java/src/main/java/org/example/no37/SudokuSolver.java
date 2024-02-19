package org.example.no37;

public class SudokuSolver {

    private final static int BOARD_SIZE = 9;

    public void solveSudoku(char[][] board) {
        this.backTracking(board);
    }

    private boolean backTracking(char[][] board) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                if (board[row][column] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, column, c)) {
                            board[row][column] = c;
                            if (backTracking(board)) {
                                return true;
                            } else {
                                board[row][column] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int column, char c) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[row][i] == c) {
                return false;
            }
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][column] == c) {
                return false;
            }
        }

        int startRow = row / 3 * 3;
        int startCol = column / 3 * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[] row1 = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        char[] row2 = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        char[] row3 = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        char[] row4 = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        char[] row5 = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        char[] row6 = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        char[] row7 = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        char[] row8 = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        char[] row9 = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        char[][] board = new char[][]{row1, row2, row3, row4, row5, row6, row7, row8, row9};
        new SudokuSolver().solveSudoku(board);
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }

}
