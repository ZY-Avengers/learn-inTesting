package github.meifans.inTesting.base;

import org.junit.Test;

/**
 * @author pengfei.zhao
 */
public class RegularSearch {


    @Test
    public void testRegular(){
        String target = "124ab14254ab";
        System.out.println(target.matches("-?\\d+(\\.\\d+)?"));
    }
}
