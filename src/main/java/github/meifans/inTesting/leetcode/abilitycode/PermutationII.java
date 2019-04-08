package github.meifans.inTesting.leetcode.abilitycode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengfei.zhao
 */
public class PermutationII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        quickSort(nums, 0, nums.length - 1);
        permute(nums, 0, result);
        return new ArrayList<>(result);
    }

    private void permute(int nums[], int i, List<List<Integer>> s) {
        if (i == nums.length - 1) {
            s.add(toList(nums));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            boolean repeated = false;
            for (int k = j - 1; k >= i; k--) {
                if (nums[j] == nums[k]) {
                    repeated = true;
                    break;
                }
            }
            if (!repeated) { // position i shouldn't repeated
                swap(nums, i, j);
                permute(nums, i + 1, s);
                swap(nums, i, j);
            }
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
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int flag = nums[right];
        int less = left - 1, i = left;
        while (i < right) {
            if (nums[i] < flag) {
                swap(nums, ++less, i);
            }
            i++;
        }
        swap(nums, ++less, right);

        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }
}
