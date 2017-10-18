package github.meifans.inTesting.leetcode;

/**
 * @author pengfei.zhao
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int il = grid.length, jl = grid[0].length;
        for (int i = 1, l = Math.max(il, jl); i < l; i++) {
            if (i < il) grid[i][0] = grid[i - 1][0] + grid[i][0];
            if (i < jl) grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < il; i++) {
            for (int j = 1; j < jl; j++)
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
        }
        return grid[il - 1][jl - 1];
    }

}
