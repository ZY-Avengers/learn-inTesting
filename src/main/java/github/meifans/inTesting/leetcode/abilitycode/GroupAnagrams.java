package github.meifans.inTesting.leetcode.abilitycode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pengfei.zhao
 */
public class GroupAnagrams {

    static int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            map.putIfAbsent(new String(chars), new ArrayList<>());
            map.computeIfPresent(new String(chars), (k, v) -> {
                v.add(str);
                return v;
            });
        }
        return new ArrayList<>(map.values());
    }

    // optimal
    public List<List<String>> groupAnagramsI(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            int key = 1;
            for (char c : str.toCharArray()) {
                key *= prime[c - 'a'];
            }

            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
                res.add(list);
            }
        }
        return res;
    }


}
