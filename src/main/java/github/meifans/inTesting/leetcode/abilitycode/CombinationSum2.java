package github.meifans.inTesting.leetcode.abilitycode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(0, candidates, target, item, res);
        return res;
    }

    private void combinationSum(int i, int[] candidates, int target, List<Integer> item, List<List<Integer>> res) {
        if (target == 0) { // sum equal
            res.add(new ArrayList<>(item));
            return;
        }
        if (i >= candidates.length || candidates[i] > target) {
            return;
        }

        int c = 1;
        while ((i + c) < candidates.length && candidates[i] == candidates[i + c])
            c++;

        for (int j = c; j > 0; j--) {
            add(item, candidates[i], j);
            combinationSum(i + c, candidates, target - (candidates[i] * j), item, res);
            remove(item, j);
        }

        combinationSum(i + c, candidates, target, item, res);
    }


    private void remove(List<Integer> item, int c) {
        while (c-- > 0) {
            item.remove(item.size() - 1);
        }
    }

    private void add(List<Integer> item, int value, int c) {
        while (c-- > 0) {
            item.add(value);
        }
    }

    @Test
    public void test() {
        int[] data = new int[]{10, 1, 2, 7, 6, 1, 5};
        new CombinationSum2().combinationSum(data, 8);
    }
}
