package github.meifans.inTesting.leetcode.abilitycode;

/**
 * @author pengfei.zhao
 */
public class IntegerToRoman {

    Roman[] romans = {of(1000, "M"), of(500, "D"), of(100, "C"), of(50, "L"), of(10, "X"), of(5, "V"), of(1, "I")};
    Roman[] decreRomans = {of(900, "XM"), of(400, "CD"), of(90, "xC"), of(50, "L"), of(10, "X"), of(5, "V"), of(1, "I")};

    /**
     * I1 V5 X10 L 50 C 100 D 500 M1000 input:1 to 3999
     */
    public String intToRoman(int num) {
        int i = num;
        StringBuilder roman = new StringBuilder();
        while (i > 0) {
            for (Roman r : this.romans) {
                if (i >= r.threshold) {
                    roman.append(r.symbol);
                    i -= r.threshold;
                }
            }
        }
        return roman.toString();
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
}
