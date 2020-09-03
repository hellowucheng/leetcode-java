package problems.H0010_正则表达式匹配;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    /* 递归 */
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean firstMatch = !s.isEmpty() && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));
        if (p.length() >1 && p.charAt(1) == '*') {
            return (firstMatch && isMatch(s.substring(1), p)) || isMatch(s, p.substring(2));
        }
        return firstMatch && isMatch(s.substring(1), p.substring(1));
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
