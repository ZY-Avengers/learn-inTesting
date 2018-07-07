package github.meifans.inTesting.leetcode.abilitycode;

/**
 * @author pengfei.zhao
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 1) {
            return strs.length == 1 ? strs[0] : "";
        }

        String common = strs[0];
        for (int i = 1; i < strs.length; i++) {
            common = commonPrefix(common, strs[i]);
            if (common.length() < 1) {
                return "";
            }
        }
        return common;
    }

    private String commonPrefix(String a, String b) {
        int maxPrefixLength = Math.min(a.length(), b.length());
        int i = 0;
        while (i < maxPrefixLength && a.charAt(i) == b.charAt(i)) {
            i++;
        }
        return a.subSequence(0, i).toString();
    }




}
