package github.meifans.inTesting.leetcode.abilitycode;

import org.junit.Test;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length;) {
            if (nums[i] > 0 && nums[i] <= nums.length && i != nums[i] - 1 && nums[nums[i] - 1] != nums[i]) {
                swap(i, nums[i] - 1, nums);
            } else {
                i++;
            }
        }

        int i = 0;
        while (i < nums.length && i == nums[i] - 1) i++;

        return i + 1;
    }

    private void swap(int i, int j, int[] nums) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    @Test
    public void test(){
        int[] data = {3, 4, -1, 1};
        new FirstMissingPositive().firstMissingPositive(data);
    }
}
