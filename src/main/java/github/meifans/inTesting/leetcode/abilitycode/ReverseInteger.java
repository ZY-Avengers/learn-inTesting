package github.meifans.inTesting.leetcode.abilitycode;
import org.junit.Test;

/**
 * @author pengfei.zhao
 */
public class ReverseInteger {

    public int reverse(int x) {
        int r = 0;
        while (true) {
            if (x == 0)
                return 0;

            r = r * 10 + x % 10;

            if ((x /= 10) == 0)
                return r;

            if (r > 214748364 || r < -214748364) {
                return 0;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(Integer.MAX_VALUE + "," + Integer.MIN_VALUE);
    }
}
