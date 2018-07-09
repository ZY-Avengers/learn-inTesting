package github.meifans.inTesting.leetcode.trend;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author pengfei.zhao
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int offset = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1, twoSum = target - nums[i];
            while (lo < hi) {
                if (Math.abs(nums[i] + nums[lo] + nums[hi] - target) < Math.abs(offset)) {
                    offset = nums[i] + nums[lo] + nums[hi] - target;
                }
                if (nums[lo] + nums[hi] > twoSum)
                    hi--;
                else
                    lo++;
            }
        }
        return offset + target;
    }

    @Test
    public void test() {
        int[] nums = {-1, 2, 1, -4};
        int[] n = {0, 2, 1, -3};
//        Assert.assertEquals(2, new ThreeSumClosest().threeSumClosest(nums, 1));
        Assert.assertEquals(0, new ThreeSumClosest().threeSumClosest(n, 1));
    }
}
