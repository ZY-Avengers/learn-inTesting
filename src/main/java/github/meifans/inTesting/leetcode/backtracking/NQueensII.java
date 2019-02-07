package github.meifans.inTesting.leetcode.backtracking;

/**
 * @author pengfei.zhao
 */
public class NQueensII {
    int[] column;
    int[] backslash;
    int[] slash;

    public int totalNQueens(int n) {
        column = new int[n];
        backslash = new int[(2 * n) - 1];
        slash = new int[(2 * n) - 1];
        char[][] chessboard = new char[n][n];
        for (char[] chars : chessboard) {
            for (int i = 0; i < chars.length; i++) {
                chars[i] = '.';
            }
        }
        return totalNQueens(chessboard, 0);
    }

    int totalNQueens(char[][] chessboard, int row) {
        if (row == column.length) {
            return 1;
        }

        int l = column.length;
        int count = 0;
        for (int i = 0; i < l; i++) {
            if (column[i] == 0 && slash[row + i] == 0 && backslash[i - row + l - 1] == 0) { // row column slash not attack
                chessboard[row][i] = 'Q';
                column[i] = 1;
                slash[row + i] = 1;
                backslash[i - row + l - 1] = 1;
                count += totalNQueens(chessboard, row + 1);
                chessboard[row][i] = '.';
                column[i] = 0;
                slash[row + i] = 0;
                backslash[i - row + l - 1] = 0;
            }
        }
        return count;
    }
}
