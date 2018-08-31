package github.meifans.inTesting.leetcode.binarysearch;

public class FindFirstAndLastPositionElementSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int mid = 0;

        int[] res = new int[]{-1, -1};

        while (low <= high) {
            mid = (low + high) / 2;

            boolean isStart = !((mid - 1) >= 0 && nums[mid - 1] == target);
            if (target == nums[mid] && isStart) {
                res[0] = mid;
                break;
            }
            if (target <= nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        low = res[0] == -1 ? 0 : res[0];

        high = nums.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;

            boolean isEnd = !((mid + 1) < nums.length && nums[mid + 1] == target);
            if (target == nums[mid] && isEnd) {
                res[1] = mid;
                break;
            }
            if (target >= nums[mid]) {
                low  = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }
}
