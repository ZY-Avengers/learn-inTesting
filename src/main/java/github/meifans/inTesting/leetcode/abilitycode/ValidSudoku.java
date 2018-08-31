package github.meifans.inTesting.leetcode.abilitycode;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] arr = new int[10];
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int index = board[i][j] - '0';
                if (arr[index] == 1) {
                    return false;
                }
                arr[index] = 1;
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            int[] arr = new int[10];
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                int index = board[j][i] - '0';
                if (arr[index] == 1) {
                    return false;
                }
                arr[index] = 1;
            }
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[0].length; j += 3) {

                int[] arr = new int[10];

                for (int k = i; k < i + 3; k++) {
                    for (int m = j; m < j + 3; m++) {
                        if (board[k][m] == '.') {
                            continue;
                        }
                        int index = board[k][m] - '0';
                        if (arr[index] == 1) {
                            return false;
                        }
                        arr[index] = 1;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku1(char[][] board) {
        int[] row = new int[9];
        int[] column = new int[9];
        int[] square = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int value = 1 << board[i][j] - '1';

                    if ((row[i] & value) != 0) {
                        return false;
                    }
                    if ((column[j] & value) != 0) {
                        return false;
                    }
                    if ((square[(i / 3 * 3 + j / 3)] & value) != 0) {
                        return false;
                    }

                    row[i] |= value;
                    column[j] |= value;
                    square[i / 3 * 3 + j / 3] |= value;
                }
            }
        }

        return true;
    }
}
