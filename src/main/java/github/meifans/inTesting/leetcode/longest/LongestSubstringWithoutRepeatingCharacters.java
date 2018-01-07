package github.meifans.inTesting.leetcode.longest;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pengfei.zhao
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;

        char[] chars = s.toCharArray();
        int from = 0, to = from, max = 1;
        int[] set = initSet(chars[from]);

        while (from < chars.length && ++to < chars.length) {
            char cur = chars[to];

            if (contain(set, cur)) {
                int firstRepeatIndex = set[cur];
                max = Math.max(max, to - from);
                invalidSet(set, chars, from, firstRepeatIndex);
                from = firstRepeatIndex + 1;
                set[cur] = to;
            } else {
                max = Math.max(max, to - from + 1);
                set[cur] = to;
            }
        }

        return max;
    }

    private void invalidSet(int[] set,char[] chars, int from, int to) {
        if (from > to || to >= chars.length) return ;

        for (int i = from; i <=to; i++) {
            set[chars[i]] = -1;
        }
    }


    private int[] initSet(char c) {
        int[] set = new int[128];
        for (int i = 1; i < set.length; i++) set[i] = -1;
        set[c] = 0;
        return set;
    }

    private boolean contain(int[] set, char c) {
        return set[c] != -1;
    }

    @Test
    public void test() {
        Map<String, Integer> cases = new HashMap<>();
        cases.put("abcabcbb", 3);
        cases.put("bbbb", 1);
        cases.put("pwwkew", 3);
        cases.put("tmmzuxt", 5);

        cases.forEach((param, expected) -> {
            Integer actual = lengthOfLongestSubstring(param);
            Assert.assertEquals(expected, actual);
        });
    }

}
