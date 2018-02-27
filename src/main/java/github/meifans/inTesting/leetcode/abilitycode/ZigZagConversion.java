package github.meifans.inTesting.leetcode.abilitycode;
import org.junit.Assert;
import org.junit.Test;

/**
 * ZigZag Conversion
 *
 * @author pengfei.zhao
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        int len = s.length();
        if (len < 2)
            return s;

        StringBuilder[] ss = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            ss[i] = new StringBuilder();

        int iter = 0;
        while (iter < len) {
            for (int i = 0; iter < len && i < numRows; i++)
                ss[i].append(s.charAt(iter++));

            for (int i = numRows - 2; iter < len && i > 0; i--)
                ss[i].append(s.charAt(iter++));
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++)
            result.append(ss[i]);

        return result.toString();
    }


    //效率最高的解法，顺序构建答案。 细节未完全掌握
    public String convertII(String s, int numRows) {
        if (numRows == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        int magic = numRows * 2 - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            buildRow(sb, i, magic, s);
        }
        return sb.toString();
    }

    private void buildRow(StringBuilder sb, int start, int magic, String s) {
        int idx = start;
        int distance1 = magic - start - start;
        int distance2 = start * 2;
        //handle first and last row
        if (distance1 == 0 || distance2 == 0) {
            distance1 = magic;
            distance2 = magic;
        }
        int count = 0;
        while (idx < s.length()) {
            sb.append(s.charAt(idx));
            if (count % 2 == 0) {
                idx += distance1;
            } else {
                idx += distance2;
            }
            count++;
        }
    }


    @Test
    public void test() {
        Assert.assertEquals("ACBD", new ZigZagConversion().convert("ABCD", 2));
    }

}
