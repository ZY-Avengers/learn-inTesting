package github.meifans.inTesting.leetcode.famousAlgorithm;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author pengfei.zhao
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty() || haystack.isEmpty()) {
            if (needle.equals(haystack) || needle.isEmpty()) {
                return 0;
            }
            return -1;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        int[] helper = new int[needle.length()];
        helper[0] = 0;
        if (helper.length > 1) helper[1] = 0;

        int i = 0, j = 0, from = 2;
        int hl = haystack.length(), nl = needle.length(), max = hl - nl;
        while (i < hl && j < nl && (i - j) <= max) {
            // look for first unequal
            if (haystack.charAt(i) == needle.charAt(j)) {
                for (; j < nl && haystack.charAt(i)
                        == needle.charAt(j); i++, j++);
            }

            // match
            if (j == nl) {
                return i - j;
            }

            // look for common prefix
            if (j != 0) {
                nextHelper(from, j, helper, needle);
                from = j + 1;
                j = helper[j];
            } else {
                i++;
            }
        }
        return -1;
    }

    private void nextHelper(int from, int to, int[] helper, String needle) {
        int k = helper[from - 1];
        for (int i = from; i < helper.length && i <= to; i++) {
            while (k > 0 && needle.charAt(k) != needle.charAt(i - 1)) {
                k = helper[k];
            }
            if (needle.charAt(k) == needle.charAt(i - 1)) {
                k++;
            }
            helper[i] = k;
        }
    }

    @Test
    public void test() {
        String haystack = "aabaaabaaac";
        String needle = "aabaaac";
        Assert.assertEquals(4, new ImplementStrStr().strStr(haystack, needle));
    }

}
