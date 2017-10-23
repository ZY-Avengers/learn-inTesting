package github.meifans.inTesting.base;

import org.junit.Test;

/**
 * @author pengfei.zhao
 */
public class RegularSearch {


    @Test
    public void testRegular() {
        String regular = "a?a?a?a?a?a?a?a?a?a?a?a?a?a?a?a?a?a?a?a?a?a?a?a?a" +
                "?aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String target = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        long before = System.currentTimeMillis();
        System.out.println(target.matches(regular));
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }
}
