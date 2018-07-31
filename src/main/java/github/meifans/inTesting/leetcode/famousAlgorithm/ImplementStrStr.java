package github.meifans.inTesting.leetcode.famousAlgorithm;

/**
 * @author pengfei.zhao
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty() || haystack.isEmpty()) {
            if (needle.equals(haystack)) {
                return 0;
            }
            if (needle.isEmpty()) {
                return 0;
            }
            return -1;
        }

        int[] helper = new int[needle.length()];
        helper[0] = 0;
        for (int i = 1; i < helper.length; i++) {
            if (i == 1) {
                helper[1] = 0;
            } else helper[i] = needle.charAt(helper[i - 1]) == needle.charAt(i - 1) ? helper[i - 1] + 1 : 0;
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

}
