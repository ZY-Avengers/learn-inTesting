package github.meifans.inTesting.structureandinterpretation;

import org.junit.Test;

/**
 * Created by Meifans on 2017/9/17.
 */
public class RegularOrder {

    int recursion() {
        return recursion();
    }

    int test(int x, int y) {
        return x == 0 ? x : y;
    }

    @Test
    public void testRegularOrder() {
        test(0, recursion());
    }
}
