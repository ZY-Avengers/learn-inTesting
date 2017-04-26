package github.meifans.inTesting.leetcode;

import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Meifans Zhao on 2017/4/22.
 */
@Log
public class Sort {


    public int[] bubble(int[] a) {

        for (int j = a.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (a[i] > a[i + 1]) {
                    a[i] = a[i] ^ a[i + 1];
                    a[i + 1] = a[i] ^ a[i + 1];
                    a[i] = a[i] ^ a[i + 1];
                }
            }
        }
        return a;
    }

    public int[] insertion(int[] a) {
        if (a == null && a.length <= 1) {
            return a;
        }
        int star = 1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                break;
            }
            star = i + 1;
        }

        log.info(star + "o");
        for (int i = star; i < a.length - 1; i++) {
            int key = a[i];
            for (int j = i - 1; j >= 0; j--) {
                if (j == 0 && a[j] > key) {
                    a[j] = a[j] ^ a[j + 1];
                    a[j + 1] = a[j] ^ a[j + 1];
                    a[j] = a[j] ^ a[j + 1];
                    break;
                }
                if (a[j] > key) {
                    a[j + 1] = a[j];
                } else {
                    a[j + 1] = key;
                    break;
                }
            }
        }
        return a;
    }

    public int binarySearch(int[] a, int target) {

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (high + low) >>> 1;
            int midVal = a[mid];
            if (midVal > target)
                high = mid - 1;
            else if (midVal < target)
                low = mid + 1;
            else
                return mid;
        }
        return -(low + 1);
    }

    public int binarySearchII(int[] a, int target) {
        return a == null ? -1 : doSearch(a, 0, a.length, target);
    }

    private static int doSearch(int[] a, int left, int right, int target) {
        if (left > right) return -1;
        int i = (left + right) / 2;
        if (target == a[i])
            return i;
        if (target > a[i])
            return doSearch(a, i + 1, right, target);
        return doSearch(a, left, i - 1, target);
    }


    @Log
    public static class SortTest {

        @Test
        public void testSort() {
//            int[] a = {2,3,2,7,4,6,4,8};
            int[] a = {2, 3, 4, 4, 8};

            int[] actual = new Sort().insertion(a);
            for (int i : actual) {
                log.info("" + i);
            }
        }

        @Test
        public void testBinarySearch() {
            int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
            int target = 8;
            int actual = new Sort().binarySearchII(a, target);
            Assert.assertEquals(Arrays.binarySearch(a, target), actual);

            actual = new Sort().binarySearch(a, target);
            Assert.assertEquals(Arrays.binarySearch(a, target), actual);
        }
    }


}
