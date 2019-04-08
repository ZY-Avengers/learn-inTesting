package github.meifans.inTesting.leetcode.abilitycode;

/**
 * @author pengfei.zhao
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }

        char[] chars = new char[a.length() + 1];
        int shift = 0, i = 0;

        while (i < a.length()) {
            int temp = i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            int cur = (a.charAt(a.length() - 1 - i) - '0') + temp + shift;

            shift = cur > 1 ? 1 : 0;
            chars[a.length() - i] = cur > 1 ? (char) ('0' + (cur - 2)) : (char) ('0' + cur);

            i++;
        }

        if (shift == 1) {
            chars[0] = '1';
            return new String(chars);
        }
        return new String(chars, 1, chars.length - 1);
    }
}
