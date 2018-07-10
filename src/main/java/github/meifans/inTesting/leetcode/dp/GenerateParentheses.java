package github.meifans.inTesting.leetcode.dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pengfei.zhao
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n > 1) {
            List<String> res = new LinkedList<>();
            for (String s : generateParenthesis(n - 1)) {
                res.add("(" + s + ")");
                if (s.startsWith("()") && s.endsWith("()")) {
                    res.add("()" + s);
                } else {
                    res.add("()" + s);
                    res.add(s + "()");
                }
            }
            return res;
        }
        return Arrays.asList("()");
    }

    @Test
    public void test() {
        String[] s = {"(((())))", "()((()))", "((()))()", "(()(()))", "()()(())", "()(())()", "((())())", "()(())()", "(())()()", "((()()))", "()(()())", "(()())()", "(()()())", "()()()()"};
        System.out.println(s);
        String[] ss = {"(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())", "(()())()", "(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()"};
        Arrays.sort(ss);
        for (int i = 0; ; i++) {
            if (!s[i].equals(ss[i])) {
                System.out.println(s[i]+":"+ss[i]);
            }
        }
        System.out.println(ss);
    }

}
