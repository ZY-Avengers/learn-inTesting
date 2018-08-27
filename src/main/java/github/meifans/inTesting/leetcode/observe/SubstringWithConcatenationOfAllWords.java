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
        List<Integer> r = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return r;

        int wl = words[0].length();
        int totalWords = words.length;
        int windowSize = wl * totalWords;

        Map<String, Integer> wordFreq = new HashMap<>();
        for (String eachWord : words)
        {
            wordFreq.put(eachWord, wordFreq.getOrDefault(eachWord, 0) + 1);
        }

        for (int i = 0; i < wl; i++)  // we don't need to scan all characters in S because every word in dictionary is same length
        {
            for (int j = i; j + windowSize <= s.length(); j += wl)
            {
                // substring of window size
                String sub = s.substring(j, j + windowSize);

                // this local hashmap lets us know if a word does not exist or if there are excessive duplicates
                Map<String, Integer> localM = new HashMap<>();
                int totalWordsMatched = 0;
                // go backward and parse each word of WL size
                for (int k = totalWords - 1; k >= 0; k--)
                {
                    int begin = k * wl;
                    int end = (k + 1) * wl;
                    String word = sub.substring(begin, end);

                    int num = localM.getOrDefault(word, 0) + 1;
                    if (num > wordFreq.getOrDefault(word, 0))  // this one check let us know if a word does not exist or an excessive duplicate
                    {
                        // this is the reason why we go backward, optimization: to be able to reset the next candidate window size
                        j = j + k*wl;
                        break;
                    }
                    localM.put(word, localM.getOrDefault(word, 0) + 1);
                    totalWordsMatched++;
                }
                if (totalWordsMatched == totalWords)
                {
                    r.add(j);
                }
            }
        }

        return r;
    }

    @Test
    public void test() {
        String[] words = {"word", "good", "best", "good"};
        String s = "wordgoodgoodgoodbestword";
        Assert.assertEquals(8, new SubstringWithConcatenationOfAllWords().findSubstring(s, words));
    }

}
