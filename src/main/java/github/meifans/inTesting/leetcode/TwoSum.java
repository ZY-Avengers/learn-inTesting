package github.meifans.inTesting.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Meifans Zhao on 2017/4/22.
 */
public class TwoSum {

  public int[] twoSumII(int[] numbers, int target) {
    if (numbers == null || numbers.length < 2) {
      return null;
    }
    Arrays.sort(numbers);

    for (int i = 0; i < numbers.length; i++) {
      int in = Arrays.binarySearch(numbers, target - numbers[i]);
      if (in < 0 || in == i) {
        continue;
      }
      return new int[]{Math.min(i + 1, in + 1), Math.max(i + 1, in + 1)};
    }
    return null;
  }

  public int[] twoSum(int[] nums, int target) { // sort+ binarySearch
    if (nums == null || nums.length < 2) {
      return null;
    }

    int[] toSort = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      toSort[i] = nums[i];
    }
    Arrays.sort(toSort);

    int toSearch, in;
    for (int i = 0; i < toSort.length; i++) {
      toSearch = target - toSort[i];
      in = Arrays.binarySearch(toSort,
          toSearch >= toSort[i] ? i + 1 : 0,
          toSearch >= toSort[i] ? toSort.length : i - 1, toSearch);

      if (in < 0 || in == i) {
        continue;
      }

      int o = -1, t = -1;
      for (int j = 0; j < nums.length; j++) {
        if (nums[j] == toSort[i] && o == -1) {
          o = j;
          continue;
        }
        if (nums[j] == toSort[in] && t == -1) {
          t = j;
        }
      }
      return new int[]{o, t};
    }
    return null;

  }

  public int[] twoSum_HashMap(int[] nums, int target){
    if(nums == null || nums.length < 2) return null;

    HashMap<Integer,Integer> map = new HashMap<>();
    int[] result = new int[2];
    for(int i = 0;i<nums.length;i++) {
      if (map.containsKey(target - nums[i])) {
        result[1] = i;
        result[0] = map.get(target - nums[i]);
        return result;
      }
      map.put(nums[i], i);
    }
    return result;
  }


  @Log
  public static class TwoSumTest {

    @Test
    public void testTwoSumII() {
      int[] numbers = {5, 25, 75};
      int[] r = new TwoSum().twoSumII(numbers, 100);
      Assert.assertArrayEquals(new int[]{2, 3}, r);
    }

    @Test
    public void testTwoSum() {
      int[] numbers = {3, 2, 4};
      int[] r = new TwoSum().twoSum(numbers, 6);
      Assert.assertArrayEquals(new int[]{1, 2}, r);

      int[] nums = {3, 3};
      r = new TwoSum().twoSum(nums, 6);
      Assert.assertArrayEquals(new int[]{0, 1}, r);

     int[] num = {3, 2, 4};
       r = new TwoSum().twoSum_HashMap(num, 6);
      Assert.assertArrayEquals(new int[]{1, 2}, r);

      int[] n = {3, 3};
      r = new TwoSum().twoSum_HashMap(n, 6);
      Assert.assertArrayEquals(new int[]{0, 1}, r);

    }
  }
}
