package github.meifans.inTesting.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengfei.zhao
 */
public class NQueens {
    int[] column;
    int[] backslash;
    int[] slash;

    public List<List<String>> solveNQueens(int n) {
        column = new int[n];
        backslash = new int[(2 * n) - 1];
        slash = new int[(2 * n) - 1];
        char[][] chessboard = new char[n][n];
        for (char[] chars : chessboard) {
            for (int i = 0; i < chars.length; i++) {
                chars[i] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        solveNQueens(res, chessboard, 0);
        return res;
    }

    void solveNQueens(List<List<String>> res, char[][] chessboard, int row) {
        if (row == column.length) {
            List<String> list = new ArrayList<>(column.length);
            for (char[] chars : chessboard) {
                list.add(new String(chars));
            }
            res.add(list);
            return;
        }

        int l = column.length;
        for (int i = 0; i < l; i++) {
            if (column[i] == 0 && slash[row + i] == 0 && backslash[i - row + l - 1] == 0) { // row column slash not attack
                chessboard[row][i] = 'Q';
                column[i] = 1;
                slash[row + i] = 1;
                backslash[i - row + l - 1] = 1;
                solveNQueens(res, chessboard, row + 1);
                chessboard[row][i] = '.';
                column[i] = 0;
                slash[row + i] = 0;
                backslash[i - row + l - 1] = 0;
            }
        }
    }
}
