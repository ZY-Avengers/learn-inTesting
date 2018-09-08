package github.meifans.inTesting.leetcode.dp;

import java.util.Stack;

/**
 * @author pengfei.zhao
 */
public class LongestValidParentheses {

    // 时间 O(m) 空间O(m)
    public int dp(String s) {
        int[] dp = new int[s.length() + 1];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == ')') {
                    int matchPos = i - dp[i] - 1;
                    if (matchPos >= 0 && s.charAt(matchPos) == '(') {
                        dp[i + 1] = dp[i] + 2 + dp[matchPos];
                        max = Math.max(max, dp[i + 1]);
                    }
                } else {
                    dp[i + 1] = dp[i - 1] + 2;
                    max = Math.max(max, dp[i + 1]);
                }
            }
        }
        return max;
    }

    // 时间 O(m) 空间O(m)
    public int longestValidParentheses(String s) {
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
                while (!stack.isEmpty() && stack.peek() != 0)
                    j += stack.pop();

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
