package github.meifans.inTesting.leetcode.longest;
import com.google.common.collect.ImmutableMap;

import org.junit.Assert;
import org.junit.Test;

/**
 * 最长回文子序列
 *
 * @author pengfei.zhao
 */
public class LongestPalindromicSubstring {

    private int start, max, len;
    private char[] a;

    /**
     * leetcode 19ms
     * 通过插入字符'0'，以便可以从每个中心点出发寻找最长回文串。
     */
    public String longestPalindromeI(String s) {
        if (s.isEmpty() || s.length() == 1)
            return s;

        char[] a = new char[2 * s.length() + 1];
        for (int i = 0; i < a.length; i += 2)
            a[i] = '0';
        for (int i = 0; i < s.length(); i++)
            a[2 * i + 1] = s.charAt(i);

        int max = 0, center = 0;
        for (int i = 0; i < a.length; i++) {

            if (i + (max / 2) > a.length)
                break;

            int palindrome = maxPalindrome(a, i);
            if (palindrome > max) {
                max = palindrome;
                center = i;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = center - (max / 2); i <= center + (max / 2); i++)
            if ((i & 0x1) == 1)
                result.append(a[i]);

        return result.toString();
    }

    public int maxPalindrome(char[] a, int center) {
        int max = 1;
        for (int i = center - 1, j = center + 1; i >= 0 && j < a.length; i--, j++, max += 2)
            if (a[i] != a[j])
                break;

        return max;
    }

    public String longestPalindromeII(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] a = s.toCharArray();

        for (int i = 0; i < s.length() - 1; i++) {
            extendPalindrome(a, i, i);
            extendPalindrome(a, i, i + 1);
        }
        return s.substring(this.start, this.start + this.max);
    }

    public void extendPalindrome(char[] a, int i, int j) {
        while (i >= 0 && j < len && a[i] == a[j]) {
            i--;
            j++;
        }
        if (this.max < (j - i - 1)) {
            this.start = i + 1;
            this.max = j - i - 1;
        }
    }

    public String longestPalindromeIII(String s) {
        a = s.toCharArray();
        len = a.length;
        if (len < 2) {
            return s;
        }
        for (int i = 0, repeat; i < len; i++) {
            repeat = i + 1;
            while (repeat < len && a[i] == a[repeat]) {
                repeat++;
            }
            extendPalindrome(a, i, repeat - 1);
            i = repeat - 1;
        }
        return s.substring(this.start, this.start + this.max);
    }

    /**
     * 10ms
     */
    public String longestPalindromeIIII(String s) {
        char[] a = s.toCharArray();
        len = a.length;
        if (len < 2) {
            return s;
        }
        for (int i = 0, repeat; i < len; i++) {
            i = update(a, i);
        }
        return s.substring(this.start, this.start + this.max);
    }

    public int update(char[] a, int k) {
        int i = k, j = k + 1;
        while (j < len && a[i] == a[j]) { // 跳过连续重复的一段
            j++;
        }
        int nextCenter = --j;

        while (i >= 0 && j < len && a[i] == a[j]) {
            i--;
            j++;
        }
        if (this.max < (j - i - 1)) {
            this.start = i + 1;
            this.max = j - i - 1;
        }
        return nextCenter;
    }


    @Test
    public void test() {
        ImmutableMap<String, String> params = ImmutableMap.of(
                "babad", "bab",
                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
        );

        LongestPalindromicSubstring s = new LongestPalindromicSubstring();
        params.forEach((input, expect) ->
                Assert.assertEquals(expect, s.longestPalindromeIIII(input)));
    }
}
