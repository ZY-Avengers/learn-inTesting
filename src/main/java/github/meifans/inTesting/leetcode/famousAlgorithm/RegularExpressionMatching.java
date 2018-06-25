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
    final static int ANY = 256;
    final static int SPLIT = 257;
    final static int START = 258;
    final static int END = 259;


    // NFA
    public static boolean isMatch(String str, String p) {
        Stack<State> sStack = new Stack<>();
        char[] chars = p.toCharArray();
        State e;
        State state;

        sStack.push(new State(START, null, null));
        for (char c : chars) {
            switch (c) {
                case '*':
                    e = sStack.pop();
                    State split = new State(SPLIT, null, e);
                    e.out = split;
                    sStack.push(split);
                    break;
                case '.':
                    e = new State(ANY, null, null);
                    sStack.push(e);
                    break;
                default:
                    e = new State(c, null, null);
                    sStack.push(e);
            }
        }
        sStack.push(new State(END, null, null));

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
        if (s != null && i == chars.length && s.isFinal()) {
            return true;
        }

        if (s != null) {
            if (s.needChar() && i < chars.length) {
                return s.isMatch(chars[i]) && (match(s.out, chars, i + 1) || match(s.out1, chars, i + 1));
            } else if (!s.needChar() && i <= chars.length) {
                return (match(s.out, chars, i) || match(s.out1, chars, i));
            }
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

        Assert.assertFalse(isMatch("ab", ".*c"));
        Assert.assertTrue(isMatch("aa", "a*"));
        Assert.assertFalse(isMatch("ab", ".*c"));
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

        public boolean needChar() {
            return c < SPLIT;
        }

        public boolean isFinal() {
            return c == END;
        }

        public boolean isMatch(int c) {
            if (this.c == ANY)
                return true;

            return this.c == c;
        }
    }

}
