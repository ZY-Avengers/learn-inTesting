package github.meifans.inTesting.leetcode.famousAlgorithm;

import org.junit.Test;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        int[] row = new int[9];
        int[] column = new int[9];
        int[] square = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int value = 1 << (board[i][j] - '1');
                row[i] |= value;
                column[j] |= value;
                square[i / 3 * 3 + j / 3] |= value;
            }
        }

        solveSudoku(0,0,board, row, column, square);
    }

    private boolean solveSudoku(int i, int j, char[][] board, int[] row, int[] column, int[] square) {
        if (i >= 9 || j >= 9) {
            return true;
        }

        if (board[i][j] != '.') {
            return solveSudoku(j == 8 ? i + 1 : i, j == 8 ? j : j + 1, board, row, column, square);
        }

        char c = '1';
        for (; (c-'1') < 9; c++) {
            int value = 1 << (c - '1');

            if (followingRules(row, column, square, i, j, value)) {
                boolean followingRules = solveSudoku(j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1, board, row, column, square);
                if (!followingRules) {
                    row[i] ^= value;
                    column[j] ^= value;
                    square[i / 3 * 3 + j / 3] ^= value;
                } else {
                    board[i][j] = c;
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private boolean followingRules(int[] row, int[] column, int[] square, int i, int j, int value) {
        if ((row[i] & value) != 0) {
            return false;
        }
        if ((column[j] & value) != 0) {
            return false;
        }
        if ((square[i / 3 * 3 + j / 3] & value) != 0) {

            return false;
        }
        row[i] |= value;
        column[j] |= value;
        square[i / 3 * 3 + j/3] |= value;
        return true;
    }

    @Test
    public void test() {
        char[][] data =new char[][] {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        new SudokuSolver().solveSudoku(data);

    }

}
