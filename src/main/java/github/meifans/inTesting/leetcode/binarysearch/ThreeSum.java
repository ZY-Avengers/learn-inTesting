package github.meifans.inTesting.leetcode.binarysearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * 3Sum
 *
 * @author pengfei.zhao
 */
@Slf4j
public class ThreeSum {

    /**
     * 朴素解法
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeTriplets = new ArrayList<>();
        Arrays.sort(nums);

        int endSearch, target;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            endSearch = nums.length - 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if ((j > i + 1 && nums[j] == nums[j - 1]) || j + 1 > endSearch) {
                    continue;
                }
                target = 0 - nums[i] - nums[j];
                int three = binarySearch(nums, j + 1, endSearch, target);
                if (three > 0) {
                    threeTriplets.add(Arrays.asList(nums[i], nums[j], nums[three]));
                    endSearch = three - 1;
                }
            }
        }
        return threeTriplets;
    }

    public List<List<Integer>> threeSumI(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> threeTriplets = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lo = i + 1, hi = nums.length - 1, target = 0 - nums[i];
            while (lo < hi) {
                if (target == nums[lo] + nums[hi]) {
                    threeTriplets.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    lo++; hi--;
                } else if (target > nums[lo] + nums[hi]) lo++;
                else hi--;
            }
        }
        return threeTriplets;
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    @Test
    public void test() {
        int[] a = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> threeTriplets = new ArrayList<>();
        threeTriplets.add(Arrays.asList(-1, -1, 2));
        threeTriplets.add(Arrays.asList(-1, 0, 1));
        List<List<Integer>> actual = new ThreeSum().threeSumI(a);
        Assert.assertEquals(threeTriplets, actual);
    }


}
