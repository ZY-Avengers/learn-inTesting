package github.meifans.inTesting.leetcode;

import org.junit.Test;

/**
 * 重点
 * point:线性时间内寻找中位数
 *
 * @author pengfei.zhao
 */
public class WiggleSortII {


    public void wiggleSortI(int[] nums) {
        int l = nums.length, k = l / 2;
        findKth(nums, k);

        int mid = nums[k], i = 0, j = 0, n = nums.length - 1;
        while (j <= n) {
            if (nums[map(l, j)] > mid) swap(nums, map(l, i++), map(l, j++));
            else if (nums[map(l, j)] < mid) swap(nums, map(l, j), map(l, n--));
            else j++;
        }

    }

    private int map(int n, int x) {
        return (2 * x + 1) % (n | 1);
    }


    private void findKth(int[] nums, int k) {
        int x = 0, s = 0, e = nums.length - 1;
        while (x != k) {
            x = findRandom(nums, s, e);
            if (x < k) s = x + 1;
            if (x > k) e = x - 1;
        }
    }

    /**
     * 错很多，重点回顾
     */
    private int findRandom(int[] nums, int s, int e) {
        int i = s;
        for (int m = nums[e]; s <= e; s++) {
            if (nums[s] > m) ;
            else swap(nums, s, i++);
        }
        return i - 1;
    }

    private void swap(int[] nums, int i, int e) {
        int val = nums[i];
        nums[i] = nums[e];
        nums[e] = val;
    }

    @Test
    public void test() {
        int[] nums = {1, 5, 1, 1, 6, 4};
        this.wiggleSortI(nums);
        for (int num : nums) {
            System.out.print(num);
        }
    }

}
