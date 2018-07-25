package github.meifans.inTesting.leetcode.abilitycode;

/**
 * @author pengfei.zhao
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int cur = 0;
        int i = nums.length - 1;
        while (cur <= i) {
            if (nums[cur] == val) {
                nums[cur] = nums[i];
                i--;
            } else {
                cur++;
            }
        }
        return cur;
    }


}
