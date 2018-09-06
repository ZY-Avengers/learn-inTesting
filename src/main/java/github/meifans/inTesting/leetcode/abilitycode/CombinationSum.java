package github.meifans.inTesting.leetcode.abilitycode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
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

        int count = target / candidates[i];
        while (count >= 0) {
            iterAdd(candidates[i], item, count);
            combinationSum(i + 1, candidates, target - (candidates[i] * count), item, res);
            iterRemove(item, count);
            count--;
        }
    }

    private void iterAdd(int candidate, List<Integer> list, int count) {
        while (count-- > 0) {
            list.add(candidate);
        }
    }

    private void iterRemove(List<Integer> list, int count) {
        while (count-- > 0) {
            list.remove(list.size() - 1);
        }
    }


    public List<List<Integer>> combinationSum100(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>(); // to record all the solutions
        List<Integer> item = new ArrayList<>(); // to record each soltuion
        Arrays.sort(candidates); // to void duplicate result.
        int start = 0; // to start with the first element
        dfs(candidates, target, start, item, result);
        return result;

    }

    private void dfs(int[] candidates, int target, int start, List<Integer> item, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(item));  // create a new item for the result.
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            item.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, item, result);
            item.remove(item.size() - 1);


        }
    }

    @Test
    public void test() {
        int[] data = new int[]{8, 7, 4, 3};
        new CombinationSum().combinationSum(data, 11);
    }
}
