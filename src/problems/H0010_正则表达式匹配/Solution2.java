package problems.H0010_正则表达式匹配;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution2 {
    class Index{
        int i;
        int j;

        public Index(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Index index = (Index) o;
            return i == index.i &&
                    j == index.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public Map<Index, Boolean> memo;


    /* 记忆化递归 */
    public boolean isMatch(String s, String p) {
        memo = new HashMap<>();
        return dp(0, 0, s, p);
    }

    // s从i开始子串 和 p从j开始子串是否匹配
    private boolean dp(int i, int j, String s, String p) {
        if (memo.containsKey(new Index(i, j))) {
            return memo.get(new Index(i, j));
        }
        if (j == p.length()) {
            return i == s.length();
        }
        boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            memo.put(new Index(i, j), (firstMatch && dp(i + 1, j, s, p)) || dp(i, j + 2, s, p));
        }
        else {
            memo.put(new Index(i, j), firstMatch && dp(i + 1, j + 1, s, p));
        }
        return memo.get(new Index(i, j));
    }

    @Test
    public void testIsMatch(){
        Assert.assertEquals(true, isMatch("", ""));
        Assert.assertEquals(false, isMatch("", "*"));
        Assert.assertEquals(true, isMatch("adfadf", ".*"));
        Assert.assertEquals(true, isMatch("a", "a*"));
        Assert.assertEquals(true, isMatch("a", "."));
        Assert.assertEquals(false, isMatch("abc", "ddd"));
    }
}
