package github.meifans.inTesting.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Meifans on 2017/10/10.
 */
public class StringtoInteger {


    public static void main(String[] args) {
        int i = Integer.parseInt("12152");
    }

    /**
     * if str is invalid,return 0.
     */
    public int atoi(String str) {
        if (str == null || !str.matches("\\s*[-+]?\\d+.*")) return 0;
        int integer = 0;
        for (int i = initIndex(str); i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') break;
            if (outRang(str, integer, i)) {
                return str.matches(".*[-]\\d+.*") ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            integer = integer * 10 + (str.charAt(i) - '0');
        }
        if (str.matches("\\s*[-+].*")) integer = str.matches(".*[-]\\d+.*") ? -integer : integer;
        return integer;
    }

    private boolean outRang(String str, int integer, int i) {
        return integer < (Integer.MIN_VALUE + (str.charAt(i) - '0')) / 10
                || integer > (Integer.MAX_VALUE - (str.charAt(i) - '0')) / 10;
    }

    private int initIndex(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).matches("[\\s-+]")) continue;
            return i;
        }
        return str.length();
    }



    public static class StringtoIntegerTest {

        StringtoInteger toTest = new StringtoInteger();

        @Test
        public void testAtoi() {
            Object[][] data = {
                    {"13435434564354453645343435", 2147483647}, {"+-4454", 0}, {"  -0012a42", -12}, // invalid
                    {"2147483648", 2147483647}, {"+2", 2}, {"1123445", 1123445}, {"-232434", -232434},
                    {"45364534-", 45364534}, {"-2147483648", -2147483648}, {"123  456", 123}, {"9223372036854775809", 2147483647},
                    {"-2147483647", -2147483647}
            }; //normal
            for (Object[] pair : data) {
                Assert.assertEquals((String) pair[0], pair[1], toTest.atoi((String) pair[0]));
            }
        }

        @Test
        public void testInteger(){
            int i = Integer.parseInt("12152",10);
            Assert.assertEquals(i,12152);
        }
    }
}
