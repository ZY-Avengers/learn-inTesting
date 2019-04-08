package github.meifans.inTesting.leetcode.abilitycode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengfei.zhao
 */
public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }

    private void permute(int nums[], int i, List<List<Integer>> s) {
        if (i == nums.length - 1) {
            s.add(toList(nums));
            return;
        }
        for (int j = i ; j < nums.length; j++) {
            swap(nums, i, j);
            permute(nums, i + 1, s);
            swap(nums, i, j);
        }
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);
        for (int num : nums) {
            res.add(num);
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
