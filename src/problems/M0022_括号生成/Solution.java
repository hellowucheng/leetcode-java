package problems.M0022_括号生成;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        dp.add(Arrays.asList(""));

        for (int i = 1; i < n + 1; i++) {
            // dp[p + q + 1] = '(' + dp[p] + ')' + dp[q]
            List<String> tmp = new ArrayList<>();
            for (int p = 0; p < i; p++) {
                for (String s1 : dp.get(p)) {
                    for (String s2 : dp.get(i - 1 - p)) {
                        tmp.add('(' + s1 + ')' + s2);
                    }
                }
            }
            dp.add(tmp);
        }
        return dp.get(n);
    }

    @Test
    public void testGenerateParenthesis() {
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
    }
}
