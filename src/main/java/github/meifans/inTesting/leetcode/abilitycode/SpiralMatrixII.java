package github.meifans.inTesting.leetcode.abilitycode;

/**
 * @author pengfei.zhao
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int tR = 0, tC = 0;
        int dR = n - 1, dC = n - 1;
        int num = 1;
        while (tR < dR && tC < dC) {
            int row = tR, column = tC;
            while (column < dC) matrix[tR][column++] = num++;
            while (row < dR) matrix[row++][dC] = num++;
            while (column > tC) matrix[dR][column--] = num++;
            while (row > tR) matrix[row--][tC] = num++;
            tR++;
            tC++;
            dR--;
            dC--;
        }
        if (tR == dR && tC == dC) {
            matrix[tR][tC] = num;
        }
        return matrix;
    }
}
