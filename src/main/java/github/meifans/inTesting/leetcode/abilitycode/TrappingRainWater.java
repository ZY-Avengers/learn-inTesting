package github.meifans.inTesting.leetcode.abilitycode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Meifans on 2018/7/6.
 */
public class TrappingRainWater {

  public int trap(int[] height) {
    if (height == null || height.length < 2) {
      return 0;
    }

    int water = 0;

    // left -> right
    int i = 0, j = 0;
    int cache = 0, nextHeight = 0;

    while (i < height.length - 1 && j < height.length) {
      if (height[i] == 0) {
        i++;
        continue;
      }
      for (j = i + 1; j < height.length;
          j++) {
        if (height[i] <= height[j]) { // larger than i first
          water = water + cache;
          i = j;
          cache = 0;
          break;
        }
        cache += height[i] - height[j];
      }
    }

    if (i == j) {
      return water;
    }

    // right -> left
    i = height.length - 1;
    j = 0;
    cache = 0;
    while (i > 0 && j >= 0) {
      if (height[i] == 0) {
        i--;
        continue;
      }
      for (j = i - 1; j >= 0; j--) {

        if (height[i] < height[j]) {
          water = water + cache;
          i = j;
          cache = 0;
          break;
        }
        cache += height[i] - height[j];
      }
    }
    return water;
  }


  @Test
  public void test() {
    int[] data = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    Assert.assertEquals(6, new TrappingRainWater().trap(data));

  }

}
