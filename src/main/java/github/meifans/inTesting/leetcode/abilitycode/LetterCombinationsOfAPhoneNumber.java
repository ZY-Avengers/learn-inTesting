package github.meifans.inTesting.leetcode.abilitycode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * recursion. Letter Combinations of a Phone Number
 *
 * @author pengfei.zhao
 */
public class LetterCombinationsOfAPhoneNumber {

    String[] map = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        letterCombinations(digits, 0, res, new char[digits.length()]);
        return res;
    }

    private void letterCombinations(String digits, int loc, List<String> res, char[] temp) {
        if (loc == digits.length()) {
            res.add(new String(temp));
        } else {
            String word = map[digits.charAt(loc) - '1'];
            for (char pre : word.toCharArray()) {
                temp[loc] = pre;
                letterCombinations(digits, loc + 1, res, temp);
            }
        }
    }

    @Test
    public void test() {
        String digits = "23";
        List<String> actual = new LetterCombinationsOfAPhoneNumber().letterCombinations(digits);
        actual.sort(Comparator.naturalOrder());
        List<String> excepted = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        excepted.sort(Comparator.naturalOrder());

        Assert.assertEquals(excepted, actual);
    }
}
