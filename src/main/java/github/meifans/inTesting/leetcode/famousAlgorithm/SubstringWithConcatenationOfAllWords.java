package github.meifans.inTesting.leetcode.famousAlgorithm;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < words.length; i++) {

            if (words[i].length() > 0) {
                Character first = words[i].charAt(0);

                if (map.containsKey(first)) {
                    map.get(first).add(i);
                } else {
                    map.put(first, new ArrayList<>());
                }

                sum += words[i].length();
            }
        }

        List<Integer> res = new ArrayList<>();

        char[] chars = s.toCharArray();
        Set<Integer> set = new HashSet<>(words.length);
        int i = 0;
        while (i < chars.length) {

            for (List<Integer> indexs = map.get(i); indexs
                    != null && !indexs.isEmpty(); i++)
                ;

            // failed
            if (i + sum < chars.length) {
                return new ArrayList<>();
            }

            int iter = i;
            while (iter < chars.length) {

                List<Integer> indexs = map.get(chars[iter]);
                if (indexs == null || indexs.isEmpty()) {
                    break;
                }

                for (int j = 0; j < indexs.size(); j++) {
                    Integer index = indexs.get(j);
                    if (set.contains(index)) {
                        continue;
                    }

                    String word = words[index];
                    int k = 0;
                    int end = chars.length - word.length();
                    if (iter < end) {
                        for (int m = iter; k < word.length() && chars[m]
                                == word.charAt(k); k++, m++)
                            ;
                    }

                    // match word
                    if (k == word.length()) {
                        set.add(j);
                        iter += word.length();
                        break;
                    }
                }

            }

            if (set.size() == words.length) {
                res.add(i);
            }
            set.clear();
        }

        return res;
    }
}
