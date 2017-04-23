package github.meifans.inTesting.leetcode;

import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Meifans Zhao on 2017/4/22.
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length <2) return null;
        Arrays.sort(numbers);

        for(int i =0; i < numbers.length ; i++) {
            int in = Arrays.binarySearch(numbers, target - numbers[i]);
            if( in < 0 || in ==i ) continue;
            return new int[]{Math.min(i+1, in+1), Math.max(i+1,in+1)};
        }
        return null;
    }

    @Log
    public static class TwoSumTest{

        @Test
        public void testTwoSum(){
            int[] numbers = {5, 25, 75};
            int[] r = new TwoSum().twoSum(numbers, 100);
            Assert.assertArrayEquals(new int[]{2,3},r);
        }
    }
}
