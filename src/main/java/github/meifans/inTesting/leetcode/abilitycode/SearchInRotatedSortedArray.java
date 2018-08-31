package github.meifans.inTesting.leetcode.abilitycode;

import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int s = 0, e = nums.length - 1;
        int mid;
        while (s <= e) {
            mid = (s + e) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (nums[mid] < nums[e] || target > nums[s]) {
                    e = mid - 1;
                } else if (target < nums[s]) {
                    s = mid + 1;
                } else {
                    return s;
                }
            } else {
                if (nums[mid] > nums[s] || target < nums[e]) {
                    s = mid + 1;
                } else if (target > nums[e]) {
                    e = mid - 1;
                } else {
                    return e;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        Assert.assertEquals(search.search(nums, 0),4);
    }
}
