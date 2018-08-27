package github.meifans.inTesting.leetcode.abilitycode;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses1(String s) {
        if (s.length() < 2) {
            return 0;
        }

        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);
            }

            if (s.charAt(i) == ')') {

                int j = 0;
                while (!stack.isEmpty() && stack.peek() != 0) j += stack.pop();

                if (stack.isEmpty()) {
                    max = Math.max(max, j);
                } else { // match
                    stack.pop();
                    stack.push(j + 2);
                }
            }
        }

        int j = 0;
        while (!stack.isEmpty()) {
            if (stack.peek() == 0) {
                stack.pop();
                max = Math.max(max, j);
                j = 0;
            } else {
                j += stack.pop();
            }
        }
        max = Math.max(max, j);

        return max;
    }


}
