package github.meifans.inTesting.leetcode.dp;

import java.util.LinkedList;
import java.util.List;

/**
 * @author pengfei.zhao
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        return generateParenthesis("", n, n, new LinkedList<>());
    }

    public List<String> generateParenthesis(String s, int left, int right, List<String> res) {
        if (left > 0) {
            generateParenthesis(s + "(", left - 1, right, res);
        }
        if (right > 0 && left < right) {
            generateParenthesis(s + ")", left, right - 1, res);
        }
        if (left == 0 && right == 0) {
            res.add(s);
        }
        return res;
    }
}
