package github.meifans.inTesting.leetcode.binarysearch;
import com.google.gson.Gson;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * @author pengfei.zhao
 */
public class MedianofTwoSortedArrays {

    /**
     * run time complexity O(m+n)
     */
    public double findMedianSortedArraysI(int[] nums1, int[] nums2) {
        int[] merged = merge(nums1, nums2);

        return getMedian(merged);

    }

    /**
     * run time complexity log(min(m,n))
     *
     * this algorithm base on binary search.
     * eg:
     * input
     *    2 5 6 7 8   ->a
     *    1 2 4       ->b
     * solution
     *    2 / 5 6 7 8
     *    1 2 4 /
     * flag=3,means spilt b before 3。then should spilt a at a[1] by finding median.
     * the slash is point of division.
     * the condition of "flag" is the answer,only when
     * a[before] <= b[after] && b[before] <= a[after] if exist.
     *
     *
     */
    public double findMedianSortedArraysII(int[] nums1, int[] nums2) {

        if (nums1.length < nums2.length) {
            return findMedianSortedArraysII(nums2, nums1);
        }

        if (nums2.length == 0) {
            return getMedian(nums1);
        }

        int total = nums1.length + nums2.length, avg = total >> 1;
        int m = 0, n = nums2.length;
        int s, l;

        for (; ; ) {
            s = (m + n) >> 1;
            l = avg - s; // if total is odd, just return min([l],[s]).

            if (s < nums2.length && nums1[l - 1] > nums2[s]) {
                m = s + 1;
            } else if (s > 0 && nums2[s - 1] > nums1[l]) {
                n = s - 1;
            } else if ((s < nums2.length && nums1[l - 1] <= nums2[s])
                    || (s > 0 && nums2[s - 1] <= nums1[l])) {

                if ((total & 1) == 1) {
                    return s == nums2.length ? nums1[l] : Math.min(nums1[l], nums2[s]);
                }
                int li = s == 0 ? 0 : nums2[s - 1];
                int lj = l == 0 ? 0 : nums1[l - 1];
                int ri = s == nums2.length ? Integer.MAX_VALUE : nums2[s];
                int rj = l == nums1.length ? Integer.MAX_VALUE : nums1[l];
                return (Math.max(li, lj) + Math.min(ri, rj)) * 0.5;
            }
        }
    }

    private boolean isEmpty(int[] nums2) {
        return nums2 == null || nums2.length == 0;
    }

    private double getMedian(int[] nums) {
        if (nums.length == 0) {
            return 0.0;
        }
        return (nums.length & 0x1) == 1
                ? nums[nums.length / 2]
                : (nums[(nums.length / 2) - 1] + nums[nums.length / 2]) / 2.0;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];

        for (int m = 0, i = 0, j = 0; i < nums1.length || j < nums2.length; m++) {

            if (i >= nums1.length && j < nums2.length) {
                while (j < nums2.length)
                    merged[m++] = nums2[j++];
                break;
            } else if (j >= nums2.length && i < nums1.length) {
                while (i < nums1.length)
                    merged[m++] = nums1[i++];
                break;
            }

            if (nums1[i] > nums2[j]) {
                merged[m] = nums2[j];
                j++;
            } else {
                merged[m] = nums1[i];
                i++;
            }
        }

        return merged;
    }


    @Test
    public void test() {
        Map<ArrayPair, Double> cases = new HashMap<>();

        cases.put(new ArrayPair(new int[]{1}, new int[]{2, 3}), 2.0);
        cases.put(new ArrayPair(new int[]{1, 2}, new int[]{3, 4}), 2.5);
        cases.put(new ArrayPair(new int[]{1}, new int[]{1}), 1.0);
        cases.put(new ArrayPair(new int[]{1, 2}, new int[]{1, 2}), 1.5);
        cases.put(new ArrayPair(new int[]{1, 3}, new int[]{2}), 2.0);
        cases.put(new ArrayPair(new int[]{1, 2}, new int[]{3, 4, 5, 6, 7, 8}), 4.5);
        cases.put(new ArrayPair(new int[]{1, 3}, new int[]{2, 4, 5, 6, 7, 8}), 4.5);
        cases.put(new ArrayPair(new int[]{3}, new int[]{1, 2}), 2.0);
        cases.put(new ArrayPair(new int[]{1, 2, 4}, new int[]{3, 5, 6}), 3.5);
        cases.put(new ArrayPair(new int[]{1, 2, 4}, new int[]{3, 5, 6, 7}), 4.0);
        cases.put(new ArrayPair(new int[]{}, new int[]{1}), 1.0);

        cases.forEach((params, expected) -> {
            try {
                Double actual = findMedianSortedArraysII(params.first, params.second);
                Assert.assertEquals(expected, actual);
            } catch (Exception e) {
                System.out.println("input:" + new Gson().toJson(params));
            }
        });

    }

    class ArrayPair {
        private int[] first;
        private int[] second;

        ArrayPair(int[] first, int[] second) {
            this.first = first;
            this.second = second;
        }
    }
}
