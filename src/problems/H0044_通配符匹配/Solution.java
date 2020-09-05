package problems.H0044_通配符匹配;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        // 首部出现'*'的情况
        for (int i = 1; i <= p.length(); i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
                else {
                    dp[i][j] = dp[i-1][j-1] && (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1));
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    @Test
    public void testIsMatch(){
        Assert.assertEquals(true, isMatch("aba", "???"));
        Assert.assertEquals(true, isMatch("ababc", "ab*c"));
        Assert.assertEquals(true, isMatch("abacd", "*"));
        Assert.assertEquals(true, isMatch("abacd", "******"));
        Assert.assertEquals(true, isMatch("abacd", "*ab*cd"));
    }
}
