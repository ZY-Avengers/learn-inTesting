package github.meifans.inTesting.leetcode.dp;

/**
 *
 * 实际是 贪心算法应用
 * @author pengfei.zhao
 */
public class JumpGameII {
    //    public int jump(int[] nums) {
    //        return jump(nums, 0);
    //    }

    // low O(2^n)
    private int jump(int[] nums, int i) {
        if (i >= nums.length - 1) {
            return 0;
        }

        int jump = nums.length;
        for (int j = 1; j <= nums[i]; j++) {
            int next = jump(nums, i + j);
            jump = Math.min(next + 1, jump);
            if (next == 1) {
                break;
            }
        }
        return jump;
    }
    //
    //        // medium O(n^2)
    //        public int jump(int[] nums) {
    //            int[] minJumps = new int[nums.length];
    //            for (int i = nums.length - 2; i >= 0; i--) {
    //                minJumps[i] = 1 + findMin(minJumps, i + 1, i + nums[i]);
    //            }
    //            return minJumps[0];
    //        }
    //
    //        private int findMin(int[] minJumps, int start, int end) {
    //            if (start >= minJumps.length) { // last index
    //                return 0;
    //            }
    //            int min = minJumps.length;
    //            while (start <= end && start < minJumps.length) {
    //                min = Math.min(min, minJumps[start]);
    //                start++;
    //            }
    //            return min;
    //        }

    //     optimal O(n)
    public int jump(int[] nums) {
        int i = 1, count = 0;
        int limit = nums[0];
        int max = 0;
        while (i <= nums.length - 1) {
            if (max < nums[i] + i) {
                max = nums[i] + i;
            }

            if (i == limit || i == nums.length - 1) {
                count++;
                limit = max;
            }

            i++;
        }
        return count;
    }


}
