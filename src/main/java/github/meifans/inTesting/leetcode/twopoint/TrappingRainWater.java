package github.meifans.inTesting.leetcode.twopoint;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TrappingRainWater {

    public int trapI(int[] height) {
        int sum = 0;
        int leftLevel = 0, leftTemp = 0;
        int rightLevel = 0, rightTemp = 0;

        for (int i = 0; i < height.length; i++) {
            if (height[i] >= leftLevel) {
                leftLevel = height[i];
                sum += leftTemp;
                leftTemp = 0;
            } else {
                leftTemp += leftLevel - height[i];
            }

            int j = height.length - i - 1;

            if (height[j] > rightLevel) {
                rightLevel = height[j];
                sum += rightTemp;
                rightTemp = 0;
            } else {
                rightTemp += rightLevel - height[j];
            }
        }
        return sum;
    }


    public int trap(int[] height) {
        List<Integer> horizontal = new ArrayList<>();

        int sum = trapLTR(height, horizontal);

        int to = height.length;
        if (!horizontal.isEmpty()) {
            to = horizontal.get(horizontal.size() - 1);
            horizontal.clear();
        }
        sum += trapRTL(to, height, horizontal);

        return sum;
    }

    private int trapLTR(int[] height, List<Integer> horizontal) {
        int max = 1;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= max) {
                max = height[i];
                horizontal.add(i);
            }
        }

        int sum = 0;
        for (int i = 0; i < horizontal.size() - 1; i++) {

            int level = height[horizontal.get(i)];
            for (int j = horizontal.get(i) + 1; j < height.length && j < horizontal.get(i + 1); j++) {
                sum += level - height[j];
            }
        }
        return sum;
    }

    private int trapRTL(int to, int[] height, List<Integer> horizontal) {

        int max = 1;
        for (int i = height.length - 1; i >= to; i--) {

            if (height[i] >= max) {
                max = height[i];
                horizontal.add(i);
            }
        }

        int sum = 0;
        for (int i = 0; i < horizontal.size() - 1; i++) {

            int level = height[horizontal.get(i)];
            for (int j = horizontal.get(i) - 1; j >= 0 && j > horizontal.get(i + 1); j--) {
                sum += level - height[j];
            }
        }
        return sum;
    }

    public int trap2(int[] height) {
        int left = 0, right = height.length - 1;
        int maxl = 0, maxr = 0;
        int rns = 0;
        while (left <= right) {
            maxl = Math.max(maxl, height[left]);
            maxr = Math.max(maxr, height[right]);

            if (maxl < maxr) {
                rns += maxl - height[left];
                left++;
            } else {
                rns += maxr - height[right];
                right--;
            }
        }
        return rns;
    }

    @Test
    public void test() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        new TrappingRainWater().trap(height);

    }
}
