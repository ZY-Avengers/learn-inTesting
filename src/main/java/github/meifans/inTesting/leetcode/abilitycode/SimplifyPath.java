package github.meifans.inTesting.leetcode.abilitycode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author pengfei.zhao
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String res = "/";
        for (int i = 1; i < path.length(); ) {
            if (path.startsWith("/", i)) {
                i = i + 1;
            } else if (path.startsWith("./", i)) {
                i = i + 2;
            } else if (i == path.length() - 1 && path.startsWith(".", i)) {
                i = i + 1;
            } else if (path.startsWith("../", i)) {
                res = res.substring(0, lastSlashIndex(res) + 1);    // back one slash
                i = i + 3;
            } else if (i == path.length() - 2 && path.startsWith("..", i)) {
                res = res.substring(0, lastSlashIndex(res) + 1);
                i = i + 2;
            } else {
                int j = nextSlashIndex(path, i);  // append one layer
                res = res + path.substring(i, j + 1);
                i = j + 1;
            }
        }
        if (res.length() != 1 && res.endsWith("/")) {
            res = res.substring(0, res.length() - 1);
        }
        return res;
    }

    private int nextSlashIndex(String path, int toffset) {
        for (int j = toffset; j < path.length(); j++) {
            if (path.charAt(j) == '/' || j == path.length() - 1) {
                return j;
            }
        }
        return toffset;
    }

    private int lastSlashIndex(String res) {
        int index = 0;
        for (int j = res.length() - 2; j >= 0; j--) {
            if (res.charAt(j) == '/') {
                index = j;
                break;
            }
        }
        return index;
    }

    @Test
    public void test() {
        String[] path = {"/a/./b/../../c", "/a//b////c/d//././/..", "/."};
        String[] expected = {"/c", "/a/b/c", "/"};
        for (int i = 0; i < path.length; i++) {
            Assert.assertEquals(expected[i], new SimplifyPath().simplifyPath(path[i]));
        }
    }
}
