package org.example.no909;

import java.util.ArrayDeque;
import java.util.Queue;

public class SnakesAndLadders {

    public int snakesAndLadders(int[][] board) {
        int n = board.length, move = 0, count = n * n;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n * n + 1];
        queue.offer(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            move++;
            for (int i = queue.size(); i > 0; i--) {
                int curr = queue.poll();
                for (int next = curr + 1; next <= Math.min(count, curr + 6); next++) {
                    int row = this.getRow(next, n), col = this.getCol(next, n);
                    int dest = board[row][col] > 0 ? board[row][col] : next;
                    if (dest == count) {
                        return move;
                    }
                    if (visited[dest]) {
                        continue;
                    }
                    queue.offer(dest);
                    visited[dest] = true;
                }
            }
        }
        return -1;
    }

    private int getRow(int curr, int n) {
        return n - 1 - (curr - 1) / n;
    }

    private int getCol(int curr, int n) {
        return ((curr - 1) / n) % 2 == 0 ? (curr - 1) % n : n - 1 - (curr - 1) % n;
    }

    public static void main(String[] args) {
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        int[] row11 = new int[]{-1, -1, -1, -1, -1, -1};
        int[] row12 = new int[]{-1, -1, -1, -1, -1, -1};
        int[] row13 = new int[]{-1, -1, -1, -1, -1, -1};
        int[] row14 = new int[]{-1, 35, -1, -1, 13, -1};
        int[] row15 = new int[]{-1, -1, -1, -1, -1, -1};
        int[] row16 = new int[]{-1, 15, -1, -1, -1, -1};
        int[][] board1 = new int[][]{row11, row12, row13, row14, row15, row16};
        System.out.println(snakesAndLadders.snakesAndLadders(board1));

        int[] row21 = new int[]{-1, -1, -1};
        int[] row22 = new int[]{-1, 9, 8};
        int[] row23 = new int[]{-1, 8, 9};
        int[][] board2 = new int[][]{row21, row22, row23};
        System.out.println(snakesAndLadders.snakesAndLadders(board2));

    }

}
