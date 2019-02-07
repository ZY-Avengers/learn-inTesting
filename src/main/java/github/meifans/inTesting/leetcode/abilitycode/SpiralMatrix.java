package github.meifans.inTesting.leetcode.abilitycode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengfei.zhao
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        int tR = 0, tC = 0, dR = matrix.length - 1, dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            if (tR == dR) {
                while (tC <= dC) res.add(matrix[tR][tC++]);
            } else if (tC == dC) {
                while (tR <= dR) res.add(matrix[tR++][tC]);
            } else {
                int curC = tC;
                int curR = tR;
                while (curC < dC) res.add(matrix[tR][curC++]);
                while (curR < dR) res.add(matrix[curR++][dC]);
                while (curC > tR) res.add(matrix[dR][curC--]);
                while (curR > tC) res.add(matrix[curR--][tC]);
            }
            tR++;
            tC++;
            dR--;
            dC--;
        }
        return res;
    }
}
