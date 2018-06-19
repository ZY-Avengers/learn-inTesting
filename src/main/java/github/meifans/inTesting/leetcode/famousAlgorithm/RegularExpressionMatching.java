package github.meifans.inTesting.leetcode.famousAlgorithm;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

/**
 * @author pengfei.zhao
 */
public class RegularExpressionMatching {
    final static int split = 256;
    final static int matchstate = 257;

    public static boolean isMatch(String s, String p) {
        Stack<Frag> fStack = new Stack<>();
        char[] chars = s.toCharArray();
        Frag e;
        State state;

        for (char c : chars) {
            switch (c) {
                case '*':
                    e = fStack.pop();
                    state = new State(split, e.start, null);
                    state.patch(e.out);

            }
        }

        e = fStack.pop();


        return false;

    }

    static class State {
        int c;
        State out;
        State out1;
        int lastList;

        public State(int c, State out, State out1) {
            this.c = c;
            this.out = out;
            this.out1 = out1;
        }

        public void patch(List<State> s) {
            if (s.size() > 0) {
                out = s.get(0);
                if (s.size() > 1) {
                    out1 = s.get(1);
                }
            }
        }

    }

    @Test
    public void test() {
        Assert.assertTrue(isMatch("aa", "a"));
        Assert.assertTrue(isMatch("aa", "aa"));
        Assert.assertTrue(isMatch("aaa", "aa"));
        Assert.assertTrue(isMatch("aa", "a*"));
        Assert.assertTrue(isMatch("aa", ".*"));
        Assert.assertTrue(isMatch("ab", ".*"));
        Assert.assertTrue(isMatch("aab", "c*a*b"));
    }

    static class Frag {
        State start;
        List<State> out;
    }
}
