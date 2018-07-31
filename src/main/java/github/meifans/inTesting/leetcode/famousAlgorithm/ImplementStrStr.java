package github.meifans.inTesting.leetcode.famousAlgorithm;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author pengfei.zhao
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty() || haystack.isEmpty()) {
            if (needle.equals(haystack)||needle.isEmpty()) {
                return 0;
            }
            return -1;
        }

        int[] helper = new int[needle.length()];
        helper[0] = 0;
        if (helper.length > 1) helper[1] = 0;
        int k = 0;
        for (int i = 2; i < helper.length; i++) {
            while (k > 0 && needle.charAt(k) != needle.charAt(i - 1)) {
                k = helper[k];
            }

            if (needle.charAt(k) == needle.charAt(i - 1)) {
                k++;
            }
            helper[i] = k;
        }

        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = helper[j];
            }
        }
        if (j == needle.length()) {
            return i - needle.length();
        }
        return -1;
    }

    @Test
    public void test() {
        String haystack = "aabaaabaaac";
        String needle = "aabaaac";
        Assert.assertEquals(4, new ImplementStrStr().strStr(haystack, needle));
    }

}
