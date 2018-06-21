package github.meifans.inTesting.leetcode.famousAlgorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author pengfei.zhao
 */
public class RegularExpressionMatching {
    final static int start = 256;
    final static int end = 257;
    final static int any = 258;

    public static boolean isMatch(String str, String p) {
        Stack<State> sStack = new Stack<>();
        char[] chars = p.toCharArray();
        State e;
        State state;

        for (char c : chars) {
            switch (c) {
                case '*':
                    e = sStack.peek();
                    e.out1 = e;
                    break;
                case '.':
                    e = new State(any, null, null);
                    sStack.push(e);
                    break;
                default:
                    e = new State(c, null, null);
                    sStack.push(e);
            }
        }

        List<State> states = new ArrayList<>(sStack); //reverse stack
        State start = null, pre, post;
        for (int i = 0, len = states.size(); i < len; i++) {
            if (i == 0 && !states.isEmpty()) {
                start = states.get(0);
            }

            if (i + 1 < len) {
                pre = states.get(i);
                post = states.get(i + 1);
                pre.out = post;
            }
        }

        return match(start, str.toCharArray(), 0);
    }


    public static boolean match(State s, char[] chars, int i) {
        if (s == null && i == chars.length) {
            return true;
        }

        if (s != null && i < chars.length) {
            return s.isMatch(chars[i]) && (
                    match(s.out, chars, i + 1) || match(s.out1, chars, i + 1));
        }

        return false;
    }

    @Test
    public void test() {
        Assert.assertFalse(isMatch("aa", "a"));
        Assert.assertTrue(isMatch("aa", "aa"));
        Assert.assertFalse(isMatch("aaa", "aa"));
        Assert.assertTrue(isMatch("aa", "a*"));
        Assert.assertTrue(isMatch("aa", ".*"));
        Assert.assertTrue(isMatch("ab", ".*"));
        Assert.assertTrue(isMatch("aab", "c*a*b"));
    }

    static class State {
        int c;
        State out;
        State out1;

        public State(int c, State out, State out1) {
            this.c = c;
            this.out = out;
            this.out1 = out1;
        }

        public boolean isMatch(int c) {
            if (this.c == any)
                return true;

            return this.c == c;
        }
    }

}
