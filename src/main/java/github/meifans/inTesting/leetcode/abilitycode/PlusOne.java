package github.meifans.inTesting.leetcode.abilitycode;

/**
 * @author pengfei.zhao
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return new int[]{1};
        }

        int last = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + last >= 10) {
                last = 1;
                digits[i] = digits[i] + last - 10;
            } else {
                digits[i] = digits[i] + last;
                last = 0;
            }
        }

        if (last == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        }
        return digits;
    }
}
