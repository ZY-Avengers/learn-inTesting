package github.meifans.inTesting.leetcode.abilitycode;

import org.junit.Test;

/**
 * Created by Meifans on 2018/7/3.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int lastLeft = 0;
        for (int i = 0; i < height.length; i++) {

            if (lastLeft >= height[i]) {
                continue;
            }
            lastLeft = height[i];

            for (int j = height.length - 1; j > i; j--) {
                int area = (j - i) * Math.min(height[i], height[j]);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    /**
     * https://leetcode.com/problems/container-with-most-water/solution/
     */
    public int maxAreaI(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return maxArea;
    }

    @Test
    public void test() {
        int[] ints = new int[15000];
        for (int i = 15000; i > 0; i--) {
            ints[15000 - i] = i;
        }
        long timeMillis = System.currentTimeMillis();
        int i = new ContainerWithMostWater().maxArea(ints);
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(i);
        System.out.println(currentTimeMillis - timeMillis);

    }

}
