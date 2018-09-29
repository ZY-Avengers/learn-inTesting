package github.meifans.inTesting.leetcode.abilitycode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pengfei.zhao
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.length() > num2.length()) {
            return multiply(num2, num1);
        }

        Map<Integer, String> cache = new HashMap<>(10);
        cache.put(0, "0");
        for (int i = 1; i <= 9; i++) {
            cache.put(i, add(num2, cache.get(i - 1)));
        }

        String sum = "0";
        StringBuilder suffix = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            String s = cache.get(x).concat(suffix.toString());
            sum = add(sum, s);
            suffix.append('0');
        }
        return sum;
    }

    private String add(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return add(s2, s1);
        }

        if (s1.length() == 0) {
            return s2;
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = 0;

        while (i < s2.length()) {
            Integer sum;

            if (i < s1.length()) {
                int x = s1.charAt(s1.length() - i - 1) - '0';
                int y = s2.charAt(s2.length() - i - 1) - '0';
                sum = x + y + carry;
            } else {
                sum = s2.charAt(s2.length() - i - 1) - '0' + carry;
            }

            if (sum > 9) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(sum.toString());
            i++;
        }

        if (carry == 1) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }

    public String multiply2(String num1, String num2) {
        int[] pos = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int mul = x * y + pos[i + j + 1];
                pos[i + j + 1] = mul % 10;
                pos[i + j] += mul / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 & p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    @Test
    public void test() {
        String s = "123";
        String s2 = "456";

        new MultiplyStrings().multiply(s, s2);

    }

}
