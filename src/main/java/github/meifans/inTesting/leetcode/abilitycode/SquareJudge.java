package github.meifans.inTesting.leetcode.abilitycode;

/**
 * @author pengfei.zhao
 */
public class SquareJudge {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int side = Math.min(length(p1, p2), length(p1, p3));
//        int
        return false;
    }

    private int length(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
