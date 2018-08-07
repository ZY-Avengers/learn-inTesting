package github.meifans.inTesting.leetcode.observe;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) {
            return new ArrayList<>();
        }

        Map<String, Integer> counts = new HashMap<>();
        for (String w : words) {
            counts.put(w, counts.getOrDefault(w, 0) + 1);
        }

        List<Integer> indexs = new ArrayList<>();

        final int sl = s.length(), wl = words[0].length(), num = words.length;
        for (int i = 0; i < sl - (wl * num) + 1; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = i;

            while (j <= sl - wl) {
                String word = s.substring(j, j + wl);
                if (counts.containsKey(word) && counts.get(word) > seen.getOrDefault(word, 0)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    j += wl;
                } else {
                    break;
                }
            }

            if (j == (wl * num) + i) {
                indexs.add(i);
            }
        }
        return indexs;
    }

    // fastest
    public List<Integer> findSubstringI(String s, String[] words) {
        List<Integer> list = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return list;
        int sLen = s.length(), wLen = words[0].length(), wsLen = words.length;
        if (sLen < wLen * wsLen)
            return list;
        Map<String, Integer> map = new HashMap<>(); // 记录words中每一个字符串的数目
        for (String word : words) {
            if (map.containsKey(word))
                map.put(word, map.get(word) + 1);
            else
                map.put(word, 1);
        }
        for (int i = 0; i < wLen; i++) {
            int left = i, right = i, window = 0; // 窗口的大小和左右边界
            while (right + (wsLen - window) * wLen <= sLen && right + wLen <= sLen) {
                String cur = s.substring(right, right + wLen); // right位置的字符串
                if (map.containsKey(cur)) {
                    int cnt = map.get(cur); // 当前字符串的个数
                    window++; // 包含当前字符串，窗口大小+1
                    if (cnt > 0) {
                        map.put(cur, cnt - 1);
                    } else { // map当前字符串个数为0，说明出现重复字符串
                        String removed = s.substring(left, left + wLen); // 从窗口左边开始移除字符串
                        while (!removed.equals(cur)) {
                            map.put(removed, map.get(removed) + 1); // 恢复移除字符串的个数
                            left += wLen;
                            window--;
                            removed = s.substring(left, left + wLen);
                        }
                        left += wLen;
                        window--;
                    }
                    if (window == wsLen) // 窗口大小等于数组长度，匹配成功
                        list.add(left);
                } else {
                    // 将map恢复原位
                    window = 0;
                    while (left < right) {
                        String removed = s.substring(left, left + wLen); // 从窗口左边开始移除字符串
                        map.put(removed, map.get(removed) + 1); // 恢复移除字符串的个数
                        left += wLen;
                    }
                    left += wLen; // 左边跳过当前这一位不匹配的字符串
                }
                right += wLen; // 窗口往右拓展一个字符串的长度
            }
            // 将map恢复原位
            while (left < right) {
                String removed = s.substring(left, left + wLen); // 从窗口左边开始移除字符串
                map.put(removed, map.get(removed) + 1); // 恢复移除字符串的个数
                left += wLen;
            }
        }

        return list;
    }

    @Test
    public void test() {
        String[] words = {"word", "good", "best", "good"};
        String s = "wordgoodgoodgoodbestword";
        Assert.assertEquals(8, new SubstringWithConcatenationOfAllWords().findSubstring(s, words));
    }

}
