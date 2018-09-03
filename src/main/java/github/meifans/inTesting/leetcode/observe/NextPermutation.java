package github.meifans.inTesting.leetcode.observe;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author pengfei.zhao
 */
public class NextPermutation {

    /**
     * 犯错原因，case太短
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }

        if (i > 0) {
            int uncertain = nums[i - 1];
            int nextHead = nums.length - 1;
            while (nextHead >= i && uncertain >= nums[nextHead]) {
                nextHead--;
            }
            swap(nums, i - 1, nextHead);
        }

        reverse(nums, i, nums.length - 1);
    }

    // int nextHead = binarySearch(nums, i, nums.length - 1, uncertain);
    private int binarySearch(int[] nums, int from, int to, int target) {
        int mid;
        while (from < to) {
            mid = (from + to) / 2;
            if (target >= nums[mid]) {
                to = mid - 1;
                if (nums[to] > target) {
                    return to;
                }
            } else if (target < nums[mid]) {
                from = mid + 1;
                if (nums[from] <= target) {
                    return from - 1;
                }
            }
        }
        return from;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private void swap(int[] nums, int j, int k) {
        nums[j] = nums[j] ^ nums[k];
        nums[k] = nums[j] ^ nums[k];
        nums[j] = nums[j] ^ nums[k];

    }

    @Test
    public void test() {
        NextPermutation tester = new NextPermutation();

        int[] nums = {2, 3, 1};
        int[] expected = {3, 1, 2};
        tester.nextPermutation(nums);
        Assert.assertArrayEquals(expected, nums);

        int[] numsI = {1, 5, 1};
        int[] expectedI = {5, 1, 1};
        tester.nextPermutation(numsI);
        Assert.assertArrayEquals(expectedI, numsI);
    }
}
