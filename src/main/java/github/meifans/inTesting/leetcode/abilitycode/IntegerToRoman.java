package github.meifans.inTesting.leetcode.abilitycode;

import org.junit.Assert;
import org.junit.Test;

/**
 * integer to roman and roman to integer
 *
 * @author pengfei.zhao
 */
public class IntegerToRoman {

    Roman[] romans = {of(1000, "M"), of(900, "CM"), of(500, "D"), of(400, "CD"), of(100, "C"), of(90, "XC"), of(50, "L"), of(40, "XL"), of(10, "X"), of(9, "IX"), of(5, "V"), of(4, "IV"), of(1, "I")};

    /**
     * 因为不是每次减完一个数至少减少一位，比如120 - 100 = 12. 要警惕减完10，可能还可以减10。
     */
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        while (num > 0) {
            for (int j = 0; j < romans.length; ) {
                if (num >= romans[j].threshold) {
                    roman.append(romans[j].symbol);
                    num -= romans[j].threshold;
                } else {
                    j++;
                }
            }
        }
        return roman.toString();
    }

    public int romanToInt(String s) {
        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            for (int j = 0; j < romans.length; ) {
                if (s.startsWith(romans[j].symbol, i)) {
                    sum += romans[j].threshold;
                    i += romans[j].symbol.length();
                } else {
                    j++;
                }
            }
        }
        return sum;
    }


    Roman of(int threshold, String symbol) {
        Roman roman = new Roman();
        roman.threshold = threshold;
        roman.symbol = symbol;
        return roman;
    }

    static class Roman {
        int threshold;
        String symbol;
    }

    @Test
    public void test() {
        Assert.assertEquals("IV", new IntegerToRoman().intToRoman(4));
        Assert.assertEquals(4, new IntegerToRoman().romanToInt("IV"));
    }


}
