package github.meifans.inTesting.leetcode.dp;

import org.junit.Test;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];
        int last = 0, temp;
        for (int i = 0; i < word1.length() + 1; i++) {
            for (int j = 0; j < word2.length() + 1; j++) {
                temp = dp[j];
                if (i == 0) {
                    dp[j] = j;
                } else if (j == 0) {
                    dp[j] = i;
                } else if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    dp[j] = Math.min(last + 1, Math.min(dp[j - 1] + 1, dp[j] + 1));
                } else {
                    dp[j] = last;
                }
                System.out.println(dp[j]);
                last = temp;
            }
        }
        return dp[word2.length()];
    }

    @Test
    public void test() {
        new EditDistance().minDistance("horse", "ros");
    }
}
