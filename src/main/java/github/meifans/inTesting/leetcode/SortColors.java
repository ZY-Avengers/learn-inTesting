package github.meifans.inTesting.leetcode;

import org.junit.Test;

/**
 *
 * point: 所想即所得，锻炼程序思维
 * @author pengfei.zhao
 */
public class SortColors {

    public void sortColors(int[] nums) {
        for (int r = 0, b = nums.length - 1, i = 0; i <= b; i++) {
            while (nums[i] == 2 && i < b) exchange(nums, i, b--);
            while (nums[i] == 0 && i > r) exchange(nums, i, r++);
        }
    }

    private void exchange(int[] nums, int i, int r) {
        if (i == r) return;
        nums[i] = nums[i] ^ nums[r];
        nums[r] = nums[i] ^ nums[r];
        nums[i] = nums[i] ^ nums[r];
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 2,0};
        int[] numss = new int[]{1, 2,0};
        sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
