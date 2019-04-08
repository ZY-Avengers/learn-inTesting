package github.meifans.inTesting.leetcode.dp;

/**
 * @author pengfei.zhao
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int limit = nums[0], max = 0;
        int i = 1;
        while (i < nums.length) {
            if (i > limit) {
                return false;
            }
            max = Math.max(max, nums[i] + i);
            if (i == limit) {
                limit = max;
            }
            i++;
        }
        return true;
    }
}
