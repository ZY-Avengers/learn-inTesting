package github.meifans.inTesting.leetcode.abilitycode;

/**
 * @author pengfei.zhao
 */
public class Sqrt {
    public int mySqrt(int x) {
        return mySqrt(x, 0, x);
    }

    int mySqrt(int x, int i, int j) {
        int mid = (i + j) / 2;
        if (mid != 0 && x / mid < mid) {
            return mySqrt(x, i, mid - 1);
        } else if (mid == 0 || x / mid > mid) {
            if (x / (mid + 1) < (mid + 1)) {
                return mid;
            }
            return mySqrt(x, mid + 1, j);
        } else {
            return mid;
        }
    }
}
