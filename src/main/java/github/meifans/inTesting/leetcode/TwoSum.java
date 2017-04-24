package github.meifans.inTesting.leetcode;

import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Meifans Zhao on 2017/4/22.
 */
public class TwoSum {
    public int[] twoSumII(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return null;
        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            int in = Arrays.binarySearch(numbers, target - numbers[i]);
            if (in < 0 || in == i) continue;
            return new int[]{Math.min(i + 1, in + 1), Math.max(i + 1, in + 1)};
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null;
        int[] toSort = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            toSort[i] = nums[i];

        Arrays.sort(toSort);
        int one = -1, two = -1;
        for (int i = 0; i < toSort.length; i++) {
            int in = Arrays.binarySearch(toSort, target - toSort[i]);
            if (in < 0 || in == i) continue;
            one = toSort[i];
            two = toSort[in];
        }
        int o = -1, t = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == one) {
                o = i;
                continue;
            }
            if (nums[i] == two) {
                t = i;
                continue;
            }
        }

        return new int[]{o, t};
    }

    @Log
    public static class TwoSumTest {

        @Test
        public void testTwoSumII() {
            int[] numbers = {5, 25, 75};
            int[] r = new TwoSum().twoSumII(numbers, 100);
            Assert.assertArrayEquals(new int[]{2, 3}, r);
        }

        @Test
        public void testTwoSum() {
            int[] numbers = {3, 2, 4};
            int[] r = new TwoSum().twoSum(numbers, 6);
            Assert.assertArrayEquals(new int[]{1, 2}, r);

            int[] nums = {3, 3};
            r = new TwoSum().twoSum(nums, 6);
            Assert.assertArrayEquals(new int[]{0, 1}, r);

        }
    }
}
