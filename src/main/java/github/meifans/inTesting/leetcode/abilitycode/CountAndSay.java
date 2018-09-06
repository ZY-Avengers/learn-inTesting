package github.meifans.inTesting.leetcode.abilitycode;

import java.util.HashMap;
import java.util.Map;

public class CountAndSay {


    public String countAndSay(int n) {
        String str = "1";

        if (n == 1) {
            return str;
        }

        while (--n > 0) {
            str = gen(str);
        }
        return str;
    }

    private String gen(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length();) {
            int count = 0;
            char c = str.charAt(i);
            while (i < str.length() && c == str.charAt(i)) {
                i++;
                count++;
            }
            sb.append(count).append(c);
        }
        return sb.toString();
    }
}
