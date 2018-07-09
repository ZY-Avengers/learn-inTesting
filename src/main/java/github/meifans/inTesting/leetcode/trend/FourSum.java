package github.meifans.inTesting.leetcode.trend;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pengfei.zhao
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);

        if (nums.length < 4 || nums[nums.length - 4] + nums[nums.length - 3] +
                nums[nums.length - 2] + nums[nums.length - 1] < target) {
            return res;
        }

        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                continue;
            }
            label1:
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int lo = j + 1, hi = nums.length - 1, sum = target - nums[i] - nums[j];
                label2:
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        if (hi - i == 3) break label1;
                        if (hi - j == 2) break label2;
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;hi--;
                    } else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        new FourSum().fourSum(nums, 0);
    }
}
