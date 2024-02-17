package org.example.no130;

public class SurroundedRegions {

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == m - 1 || i == 0 || j == n - 1 || j == 0) {
                    this.dfs(board, m, n, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int m, int n, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] == 'X' || board[r][c] == 'Y') {
            return;
        }
        board[r][c] = 'Y';
        this.dfs(board, m, n, r + 1, c);
        this.dfs(board, m, n, r - 1, c);
        this.dfs(board, m, n, r, c + 1);
        this.dfs(board, m, n, r, c - 1);
    }

    public static void main(String[] args) {
        char[] row1 = new char[]{'X', 'X', 'X', 'X'};
        char[] row2 = new char[]{'X', 'O', 'O', 'X'};
        char[] row3 = new char[]{'X', 'X', 'O', 'X'};
        char[] row4 = new char[]{'X', 'O', 'X', 'X'};
        char[][] board = new char[][]{row1, row2, row3, row4};
        new SurroundedRegions().solve(board);
    }

}
