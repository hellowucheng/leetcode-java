package problems.M0131_分割回文串;

import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

public class Solution {

    private List<List<String>> split(String s, int i, boolean[][] dp) {
        if (i == s.length()) {
            List<List<String>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        List<List<String>> result = new ArrayList<>();
        for (int j = i; j < s.length(); j++) {
            if (dp[i][j]) {
                List<List<String>> parts = split(s, j+1, dp);
                for (List<String> part : parts) {
                    part.add(0, s.substring(i, j+1));
                    result.add(part);
                }
            }
        }
        return result;
    }

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        // dp[i][j] 表示以[i, j]是否回文
        boolean[][] dp = new boolean[s.length()][s.length()];
        // i从后往前遍历, j从前往后遍历 dp[i][j] = (s[i]==s[j]) && dp[i+1][j-1]
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = j - i + 1 <= 3 || dp[i + 1][j - 1];
                }
            }
        }
        return split(s, 0, dp);
    }

    @Test
    public void testPartition() {
        System.out.println(partition("abaa"));
    }
}
