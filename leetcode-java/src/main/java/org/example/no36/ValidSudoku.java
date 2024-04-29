package org.example.no36;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> columnMap = new HashMap<>();
        Map<Integer, Set<Character>> boxMap = new HashMap<>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (rowMap.getOrDefault(r, new HashSet<>()).contains(board[r][c])) {
                    return false;
                } else {
                    if (!rowMap.containsKey(r)) {
                        rowMap.put(r, new HashSet<>());
                    }
                    if (board[r][c] != '.') {
                        rowMap.get(r).add(board[r][c]);
                    }
                }

                if (columnMap.getOrDefault(c, new HashSet<>()).contains(board[r][c])) {
                    return false;
                } else {
                    if (!columnMap.containsKey(c)) {
                        columnMap.put(c, new HashSet<>());
                    }
                    if (board[r][c] != '.') {
                        columnMap.get(c).add(board[r][c]);
                    }
                }

                int boxKey = 3 * (r / 3) + c / 3;
                if (boxMap.getOrDefault(boxKey, new HashSet<>()).contains(board[r][c])) {
                    return false;
                } else {
                    if (!boxMap.containsKey(boxKey)) {
                        boxMap.put(boxKey, new HashSet<>());
                    }
                    if (board[r][c] != '.') {
                        boxMap.get(boxKey).add(board[r][c]);
                    }
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
        System.out.println(new ValidSudoku().isValidSudoku(board));
    }

}
