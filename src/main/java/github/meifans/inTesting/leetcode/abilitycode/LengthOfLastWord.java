package github.meifans.inTesting.leetcode.abilitycode;

/**
 * @author pengfei.zhao
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int length = 0;
        for (int i = 0; i < chars.length; i++) {
            int cur = 0;
            while (i < chars.length && chars[i] != ' ') {
                i++;
                length = ++cur;
            }
        }
        return length;
    }
}
