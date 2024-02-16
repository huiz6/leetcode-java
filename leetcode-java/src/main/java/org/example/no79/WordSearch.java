package org.example.no79;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int height = board.length;
        int width = board[0].length;
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                StringBuilder sb = new StringBuilder().append(board[h][w]);
                boolean[][] record = new boolean[height][width];
                record[h][w] = true;
                if (this.dfs(board, height, width, sb, h, w, record, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int height, int width, StringBuilder sb, int h, int w, boolean[][] record, String word) {
        if (sb.length() == word.length()) {
            return word.contentEquals(sb);
        } else {
            if (!word.startsWith(sb.toString())) {
                return false;
            }
        }
        int[][] nexts = new int[4][2];
        nexts[0] = new int[]{h + 1, w};
        nexts[1] = new int[]{h - 1, w};
        nexts[2] = new int[]{h, w + 1};
        nexts[3] = new int[]{h, w - 1};

        for (int[] next : nexts) {
            int nextH = next[0];
            int nextW = next[1];
            if (nextH < height && nextH >= 0 && nextW >= 0 && nextW < width && !record[nextH][nextW]) {
                sb.append(board[nextH][nextW]);
                record[nextH][nextW] = true;
                if (!this.dfs(board, height, width, sb, nextH, nextW, record, word)) {
                    sb.deleteCharAt(sb.length() - 1);
                    record[nextH][nextW] = false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[] chars1 = new char[]{'A', 'B', 'C', 'E'};
        char[] chars2 = new char[]{'S', 'F', 'C', 'S'};
        char[] chars3 = new char[]{'A', 'D', 'E', 'E'};
        char[][] board = new char[][]{chars1, chars2, chars3};

//        char[] chars1 = new char[]{'a', 'b'};
//        char[][] board = new char[][]{chars1};
        System.out.println(new WordSearch().exist(board, "ABCESCFSADEE"));

    }

}
