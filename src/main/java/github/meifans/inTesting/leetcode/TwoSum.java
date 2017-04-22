package github.meifans.inTesting.leetcode;

import java.util.Arrays;

/**
 * Created by Meifans Zhao on 2017/4/22.
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length <2) return null;
        Arrays.sort(numbers);
        for(int i =0; i<numbers.length; i++) {
            int in = Arrays.binarySearch(numbers, target - numbers[i]);

        }
        return null;
    }
}
