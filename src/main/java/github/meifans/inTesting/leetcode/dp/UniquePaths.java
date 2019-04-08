package github.meifans.inTesting.leetcode.dp;

import org.junit.Test;

/**
 * @author pengfei.zhao
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] help = new int[m];
        for (int i = 0; i < m; i++) {
            help[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                help[j] = help[j] + help[j - 1];
            }
        }
        return help[m - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (i == 0 && j == 0) {
                    obstacleGrid[0][0] = 1 - obstacleGrid[0][0];
                } else if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = (i == 0 ? 0 : obstacleGrid[i - 1][j]) + (j == 0 ? 0 : obstacleGrid[i][j - 1]);
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public int uniquePathsWithObstaclesII(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int last = 1;
        for (int i = 0; i < m; i++) {
            if (last != 0 && obstacleGrid[i][0] == 1) {
                last = 0;
            }
            obstacleGrid[i][0] = last;
        }
        last = obstacleGrid[0][0];
        for (int i = 1; i < n; i++) {
            if (last != 0 && obstacleGrid[0][i] == 1) {
                last = 0;
            }
            obstacleGrid[0][i] = last;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
    @Test
    public void test() {
        int[][] s = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        new UniquePaths().uniquePathsWithObstacles(s);


    }
}
