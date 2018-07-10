package github.meifans.inTesting.leetcode.abilitycode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author pengfei.zhao
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        char c;
        while (i < s.length()) {
            c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.empty() || !matchParentheses(stack.pop(), c)) {
                return false;
            }
            i++;
        }
        return stack.empty();
    }

    private boolean matchParentheses(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
    }

    @Test
    public void test() {
        String s1 = "()[]{}";
        Assert.assertEquals(true, new ValidParentheses().isValid(s1));
        String s2 = "]";
        Assert.assertEquals(false, new ValidParentheses().isValid(s2));


    }

}
