package github.meifans.inTesting.leetcode.abilitycode;

/**
 * @author pengfei.zhao
 */
public class Pow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 0x80000000) {
            return myPow(1 / x * 1 / x, (0x7fffffff / 2) + 1);
        }

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        return (n & 1) == 1 ? x * myPow(x * x, n / 2) : myPow(x * x, n / 2);
    }
}
