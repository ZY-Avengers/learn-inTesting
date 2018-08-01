package github.meifans.inTesting.leetcode.abilitycode;

import org.junit.Assert;
import org.junit.Test;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        long did = Math.abs((long) dividend);
        long dir = Math.abs((long) divisor);
        long cur = dir, num = 0, res = 0;

        while (did >= cur) {
            while ((cur * 2) < did) {
                cur = cur << 1; // error point (<< 2)
                num++;
            }
            did -= cur;
            res += Math.pow(2, num);
            cur = dir;
            num = 0;
        }
                                                // error point
        return (dividend ^ divisor) >= 0 ? ((res - 1) == 0x7fffffff ? 0x7fffffff : (int) res) : (int) -res;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, new DivideTwoIntegers().divide(10, 3));
        Assert.assertEquals(2147483647, new DivideTwoIntegers().divide(-2147483648 ,-1));
    }
}
