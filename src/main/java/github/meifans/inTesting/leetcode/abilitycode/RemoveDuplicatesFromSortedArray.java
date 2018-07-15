package github.meifans.inTesting.leetcode.abilitycode;

/**
 * @author pengfei.zhao
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int cur = 0;
        for (int i = 1; i < nums.length;i++) {
            if (nums[cur] != nums[i]) {
                cur++;
                nums[cur] = nums[i];
            }
        }
        return cur + 1;
    }
}
