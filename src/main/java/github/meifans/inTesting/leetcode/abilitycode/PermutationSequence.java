package github.meifans.inTesting.leetcode.abilitycode;

/**
 * @author pengfei.zhao
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        return getPermutation(n, k - 1, SortNums.of(n));
    }

    String getPermutation(int n, int k, SortNums nums) {
        if (n == 1) {
            return String.valueOf(nums.getKth(0));
        }
        int p = 1, i = 1;
        while (++i < n) p *= i;

        return nums.getKth(k / p) + getPermutation(n - 1, k % p, nums);
    }

    static class SortNums {
        int[] nums;

        static SortNums of(int n) {
            SortNums nums = new SortNums();
            nums.nums = new int[n];
            for (int i = 0; i < nums.nums.length; i++) {
                nums.nums[i] = i + 1;
            }
            return nums;
        }

        int getKth(int k) {
            int kth = nums[k];
            while (++k < nums.length && nums[k] != 0) {
                nums[k - 1] = nums[k];
            }
            nums[k - 1] = 0;
            return kth;
        }
    }
}
