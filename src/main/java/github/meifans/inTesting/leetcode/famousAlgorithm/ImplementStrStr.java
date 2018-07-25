package github.meifans.inTesting.leetcode.famousAlgorithm;

/**
 * @author pengfei.zhao
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int i;
        int lastMatch;
        for (int j = 0; j < haystack.length(); j++) {
            i = j;
            for (int k = j, m = 0; k < haystack.length(); k++, m++) {

                if (haystack.charAt(k) != needle.charAt(m)) {
                    break;
                }
                if (m == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

}
