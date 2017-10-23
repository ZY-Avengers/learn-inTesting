package github.meifans.inTesting.leetcode;

import org.junit.Test;

/**
 * point: char,unicode
 * @author pengfei.zhao
 */
public class ValidAnagram {


    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        char[] chars = new char[128];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            chars[t.charAt(i)]--;
        }
        for (int i = 0; i < 128; i++) {
            if (chars[i] != 0) return false;
        }
        return true;
    }

    @Test
    public void testUnicode() {
        char[] chars = new char[128];
        for (int i = 0; i < 10; i++) {
//            chars[1]++;

            System.out.println((int) chars[1]);
            chars[1]--;
            System.out.println((int) chars[1]);
//            System.out.println((int)((byte)--chars[i]));
//            System.out.println((int) chars[i]);
//            System.out.println(((int) --chars[i]));
//            System.out.println(( --chars[i]));

        }
//        System.out.println((int) Math.pow(2, 16));

    }
}
