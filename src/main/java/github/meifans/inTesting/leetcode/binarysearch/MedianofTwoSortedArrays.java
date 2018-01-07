package github.meifans.inTesting.leetcode.binarysearch;
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
     * run time complexity
     */
    public double findMedianSortedArraysII(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null)
            return 0.0;

        if (nums1 == null || nums2 == null) {
            return nums1 == null
                    ? getMedian(nums2)
                    : getMedian(nums1);
        }
        int[] first = nums1.length > nums2.length ? nums1 : nums2;
        int[] second = nums1.length > nums2.length ? nums2 : nums1;
        int fi = (nums1.length + nums2.length) / 2;
        int fv = first[fi];
        int si = binarySearchFirstLE(second, fv);
        int sv = second[si];
        int target = fi;

        while ((fi + si + 2) > target) {

        }

        return 0.0;


    }

    private int binarySearchFirstLE(int[] a, int v) {
        int i = 0, j = a.length, m = 0;
        while (i <= j) {
            m = (i + j) / 2;

            if (a[m] < v)
                i = m + 1;
            else if (a[m] > v)
                j = m - 1;
            else
                return m;
        }
        return a[m] < v ? m : m - 1;
    }

    private double getMedian(int[] nums) {
        return (nums.length & 1) == 1
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
        cases.put(new ArrayPair(new int[]{1, 3}, new int[]{2}), 2.0);
        cases.put(new ArrayPair(new int[]{1, 2}, new int[]{3, 4}), 2.5);

        cases.forEach((params, expected) -> {
            Double actual = findMedianSortedArraysII(params.first, params.second);
            Assert.assertEquals(expected, actual);
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
