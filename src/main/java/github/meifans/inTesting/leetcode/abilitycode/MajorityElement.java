package github.meifans.inTesting.leetcode.abilitycode;

/**
 * @author pengfei.zhao
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majority = 0;
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (times == 0) {
                majority = nums[i];
                times = 1;
            } else {
                if (nums[i] == majority) {
                    times += 1;
                } else {
                    times -= 1;
                }
            }
        }
        return majority;
    }
}
