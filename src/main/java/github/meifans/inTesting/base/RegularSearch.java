package github.meifans.inTesting.base;

import org.junit.Test;

/**
 * @author pengfei.zhao
 */
public class RegularSearch {


    @Test
    public void testRegular(){
        String target = "aaaa";
        System.out.println(target.matches("a+a"));
    }
}
