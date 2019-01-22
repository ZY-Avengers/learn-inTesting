package main.java.github.meifans.inTesting.leetcode.abilitycode;

import org.junit.Test;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String res = "/";
        for (int i = 0; i < path.length(); ) {
            if (startWith(path, i + 1, "/")) {
                i = i + 2;
            } else if (startWith(path, i + 1, "./")) {
                i = i + 3;
            } else if (startWith(path, i + 1, "../")) {
                int index = 0;
                for (int j = res.length() - 2; j >= 0; j--) {
                    if (res.charAt(j) == '/') {
                        index = j;
                        break;
                    }
                }
                res = res.substring(0, index + 1);
                i = i + 4;
            } else {
                for (int j = i + 1; j < path.length(); j++) {
                    if (path.charAt(j) == '/') {
                        res = res + path.substring(i + 1, j + 1);
                        i = j;
                        break;
                    }
                    if (j == path.length() - 1) {
                        return res + path.substring(i + 1, j + 1);
                    }
                }
            }
        }
        if (res.length() != 1 && res.endsWith("/")) {
            res = res.substring(0, res.length() - 1);
        }
        return res;
    }

    boolean startWith(String path, int start, String prefix) {
        int i = 0;
        while (start < path.length() && i < prefix.length()) {
            if (path.charAt(start) != prefix.charAt(i)) {
                return false;
            }
            start++;
            i++;
        }
        return i == prefix.length();
    }


    @Test
    public void test() {
        new SimplifyPath().simplifyPath("/a/./b/../../c/");
    }
}
