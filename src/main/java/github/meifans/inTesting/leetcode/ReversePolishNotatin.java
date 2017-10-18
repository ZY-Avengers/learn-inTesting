package github.meifans.inTesting.leetcode;

import org.junit.Test;


/**
 * @author pengfei.zhao
 */
public class ReversePolishNotatin {

    public int evalRPN(String[] tokens) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (String token : tokens) {
            if (token.matches("[+\\-\\*\\/]")) {
                int result = operate(stack.pop(), stack.pop(), token);
                stack.push(result);
                continue;
            }
            stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }


    private int operate(int j, int i, String operate) {
        switch (operate) {
            case "*": return i*j;
            case "-": return i-j;
            case "+": return i+j;
            case "/": return i/j;
            default : return 0;
        }
    }

    @Test
    public void test() {
        String[][] s = {
//                {"0", "3", "/"},
                {"2", "1", "+", "3", "*"},
                {"18"},
                {"4", "13", "5", "/", "+"},
                {"2", "1", "+", "3", "*"}
        };
        for (String[] tokens : s) {
            int actual = this.evalRPN(tokens);
            System.out.println(actual);
        }
    }

    static class Calculation {
        int index;
        int value;

        public Calculation(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
