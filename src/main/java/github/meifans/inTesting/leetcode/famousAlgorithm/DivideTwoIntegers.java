package github.meifans.inTesting.leetcode.famousAlgorithm;

/**
 * @author pengfei.zhao
 */
public class DivideTwoIntegers {
    int divide(int dividend, int divisor) {
        long did = Math.abs((long) dividend);
        long dir = Math.abs((long) divisor);
        long cur = dir, num = 0, res = 0;

        while (did >= cur) {
            while (cur << 2 < did) {
                cur = cur << 2;
                num++;
            }
            did -= cur;
            res += Math.pow(2, num);
            cur = dir;
            num = 0;
        }

        return (dividend ^ divisor) > 0 ? (res == 0x8fffffff ? 0x7fffffff : (int) res) : (int) -res;
    }

    public String test(String s) {
        return 'a' + s;
    }
}
