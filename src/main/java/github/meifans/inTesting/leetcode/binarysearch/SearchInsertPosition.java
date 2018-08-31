package github.meifans.inTesting.leetcode.binarysearch;

import org.junit.Test;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;

            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return nums[low] >= target ? low : low + 1;
    }

    @Test
    public void test() {
        SearchInsertPosition position = new SearchInsertPosition();
        int[] ints = {1, 3, 5, 6};
        position.searchInsert(ints, 0);
    }
}

